package com.alan.eurekaProject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Alan Huang
 * @version v1
 * @Title EurekaApplication
 * @date 2021/6/15-15:23
 * @Email cmrhyq@163.com
 */
@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        SpringApplication.run(EurekaApplication.class, args);
        long endTime = System.currentTimeMillis();
        log.info("程序启动耗时：" + (endTime - beginTime) + "ms");
    }

}
