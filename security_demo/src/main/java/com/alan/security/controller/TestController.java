package com.alan.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Alan Huang
 * @version v1
 * @Title Controller
 * @date 2021/6/5-20:13
 * @Email cmrhyq@163.com
 */
@Slf4j
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("当前登陆用户：" + name);
        return "homePage";
    }

    @RequestMapping("login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "ROLE_ADMIN角色验证成功";
    }

    @RequestMapping("user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "ROLE_USER角色验证成功";
    }
}
