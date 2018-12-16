package org.liangxiong.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2018-12-16
 * @Time:11:16
 * @Description 用于集成测试
 */
@RestController
@RequestMapping("/test/integration")
public class IntegrationController {

    @GetMapping
    public String hello(String name) {
        return "hello, " + name;
    }
}
