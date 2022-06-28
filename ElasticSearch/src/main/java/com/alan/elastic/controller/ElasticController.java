package com.alan.elastic.controller;

import com.alan.elastic.config.Configuration;
import com.alan.elastic.config.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Alan Huang
 * @version v1
 * @title BlogController
 * @date 2021/4/16-15:01
 * @email cmrhyq@163.com
 */
@Slf4j
@RestController
public class ElasticController {

    @Autowired
    PositionService positionService;

    @RequestMapping("/importAll")
    public String importAll(@RequestParam("tableName") String tableName){
        try {
            return positionService.importAll(tableName);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
