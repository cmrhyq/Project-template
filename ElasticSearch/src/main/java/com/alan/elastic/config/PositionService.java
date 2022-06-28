package com.alan.elastic.config;

import com.alan.elastic.database.DBHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Alan Huang
 * @version v1
 * @Title PositionService
 * @date 2021/4/18-8:59
 * @Email cmrhyq@163.com
 */
@Slf4j
@Service("positionService")
public class PositionService {

    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    RestHighLevelClient client;

    static ESConfiguration esConfiguration = new ESConfiguration();
    public static BulkProcessor bulkProcessor;
    public static RestHighLevelClient esClient;

    public String importAll(String tableName) throws IOException {
        return writeMysqlDataToES(tableName);
    }

    /**
     * 讲数据批量写入ES中
     */
    private String writeMysqlDataToES(String tableName) {
        BulkProcessor bulkProcessor = getBulkProcessor(client);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBHelper.getConn();
            System.out.println("Start handle data :" + tableName);
            String sql = "SELECT * from " + tableName;
            ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            // 根据自己需要 设置
            ps.setFetchSize(20);
            rs = ps.executeQuery();
            ResultSetMetaData colData = rs.getMetaData();
            ArrayList<HashMap<String, String>> dataList = new
                    ArrayList<HashMap<String, String>>();
            // bulkProcessor 添加的数据支持的方式并不多，查看其api发现其支持map键值对的方式，故笔者在此将查出来的数据转换成hashMap方式
            HashMap<String, String> map = null;
            String c = null;
            String v = null;
            while (rs.next()) {
                count++;
                map = new HashMap<String, String>(128);
                for (int i = 1; i <= colData.getColumnCount(); i++) {
                    c = colData.getColumnName(i);
                    v = rs.getString(c);
                    map.put(c, v);
                }
                dataList.add(map);
                // 每1万条写一次，不足的批次的最后再一并提交
                if (count % 10000 == 0) {
                    System.out.println("Mysql handle data number : " + count);
                    // 将数据添加到 bulkProcessor 中
                    for (HashMap<String, String> hashMap2 : dataList) {
                        bulkProcessor.add(
                                new IndexRequest(tableName).source(hashMap2));
                    }
                    // 每提交一次便将map与list清空
                    map.clear();
                    dataList.clear();
                }
            }
            // 处理未提交的数据
            for (HashMap<String, String> hashMap2 : dataList) {
                bulkProcessor.add(
                        new IndexRequest(tableName).source(hashMap2));
                System.out.println(hashMap2);
            }
            System.out.println("-------------------------- Finally insert number total: " + count);
            // 将数据刷新到es, 注意这一步执行后并不会立即生效，取决于bulkProcessor设置的刷新时间
            bulkProcessor.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
                boolean terminatedFlag = bulkProcessor.awaitClose(150L,
                        TimeUnit.SECONDS);
                System.out.println(terminatedFlag);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "Finally insert number total：" + count + "条";
    }

    private BulkProcessor getBulkProcessor(RestHighLevelClient client) {
        BulkProcessor bulkProcessor = null;
        try {
            BulkProcessor.Listener listener = new BulkProcessor.Listener() {
                @Override
                public void beforeBulk(long executionId, BulkRequest request) {
                    System.out.println("Try to insert data number : " + request.numberOfActions());
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request,
                                      BulkResponse response) {
                    System.out.println("************** Success insert data number : " + request.numberOfActions() + " , id: " + executionId);
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request,
                                      Throwable failure) {
                    System.out.println("Bulk is unsuccess : " + failure + ",executionId: " + executionId);
                }
            };
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(Configuration.USERNAME, Configuration.PASSWORD));
            esClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(Configuration.HOST, Configuration.PORT)
                    ).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                        @Override
                        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
                            httpAsyncClientBuilder.disableAuthCaching();
                            return httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                        }
                    })
            );
            bulkProcessor = ESConfiguration.bulkProcessor(esClient);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                bulkProcessor.awaitClose(100L, TimeUnit.SECONDS);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
        return bulkProcessor;
    }
}
