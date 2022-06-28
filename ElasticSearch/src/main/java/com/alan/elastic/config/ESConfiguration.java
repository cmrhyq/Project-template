package com.alan.elastic.config;

import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;

import java.net.UnknownHostException;

/**
 * @author Alan Huang
 * @version v1
 * @Title ESConfiguration
 * @date 2021/4/18-15:26
 * @Email cmrhyq@163.com
 */
public class ESConfiguration {
    public static BulkProcessor bulkProcessor(RestHighLevelClient esClient) throws UnknownHostException {

        BulkProcessor.Listener listener = new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long l, BulkRequest bulkRequest) {

            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {
            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {
                System.out.println("{} data bulk failed,reason :{}" + bulkRequest.numberOfActions() + throwable);
            }
        };
        BulkProcessor bulkProcessor = BulkProcessor.builder(
                (request, bulkListener) -> esClient.bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
                listener)
                //每50000条执行一次bulk
                .setBulkActions(50000)
                //每达到10m的size，执行一次bulk
                .setBulkSize(new ByteSizeValue(10, ByteSizeUnit.MB))
                //5min刷新索引
                .setFlushInterval(TimeValue.timeValueSeconds(300))
                //默认是1，表示积累bulk requests和发送bulk是异步的，其数值表示发送bulk的并发线程数，设置为0表示二者同步的
                .setConcurrentRequests(10)
                //当ES由于资源不足发生异常EsRejectedExecutionException重試策略：默认（50ms, 8）,
                .setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))

                .build();
        return bulkProcessor;
    }
}
