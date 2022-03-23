package com.alan.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        SpringApplication.run(SecurityApplication.class, args);
        long endTime = System.currentTimeMillis();
        log.info("程序启动耗时：" + (endTime - beginTime) + "ms");
    }

}
