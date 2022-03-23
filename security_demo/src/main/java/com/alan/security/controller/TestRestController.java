package com.alan.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alan Huang
 * @version v1
 * @Title TestController
 * @date 2021/6/5-0:41
 * @Email cmrhyq@163.com
 */
@RestController
@RequestMapping("/")
public class TestRestController {

    @GetMapping("test")
    public String test() {
        return "hello";
    }
}
