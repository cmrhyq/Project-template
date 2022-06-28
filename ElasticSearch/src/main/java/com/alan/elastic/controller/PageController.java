package com.alan.elastic.controller;

/**
 * @author Alan Huang
 * @version v1
 * @Title PageController
 * @date 2021/4/18-16:26
 * @Email cmrhyq@163.com
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("commitData")
    public String commitData() {
        return "commitData";
    }
}
