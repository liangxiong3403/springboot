package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author liangxiong
 * Date:2018-10-04
 * Time:22:03
 * @Description 模板引擎测试类
 */
@Controller
public class IndexController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RestTemplateBuilder builder;

    /**
     * JSP视图测试
     *
     * @return
     */
    @GetMapping("/jsp/index")
    public String jsp() {
        return "test";
    }

    /**
     * velocity视图测试
     *
     * @return
     */
    @GetMapping("/velocity/index")
    public String velocity() {
        return "test2";
    }

    /**
     * thymeleaf视图测试
     *
     * @return
     */
    @GetMapping("/thymeleaf/index")
    public String thymeleaf() {
        return "test3";
    }

    /**
     * 针对404请求
     *
     * @return
     */
    @GetMapping("/404")
    public String notFound() {
        return "notfound";
    }

    /**
     * 测试自定义异常捕捉
     */
    @GetMapping("/diy/error")
    public void diyError() {
        throw new RuntimeException("diy error response");
    }

    /**
     * 测试Spring Security对方法级别权限控制
     *
     * @return
     */
    @PreAuthorize("false")
    @GetMapping("deny")
    @ResponseBody
    public String deny() {
        return "access deny";
    }

    /**
     * 退出应用
     */
    @GetMapping("/exit")
    public void exit() {
        SpringApplication.exit(context);
    }

    /**
     * 通过RestTemplate发送请求
     *
     * @return
     */
    @GetMapping("/template")
    @ResponseBody
    public School testClient() {
        // 通过SpringBoot提供地RestTemplateBuilder进行RestTemplate的自定义
        RestTemplate restTemplate = builder.basicAuthorization("admin", "123456").build();
        return restTemplate.getForObject("http://localhost:9999/rest/json/school", School.class);
    }
}
