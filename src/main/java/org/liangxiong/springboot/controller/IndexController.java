package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangxiong
 * Date:2018-10-04
 * Time:22:03
 * @Description 测试相关非功能性API
 */
@Validated
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
    public School requestFromRemoteServer() {
        // 通过SpringBoot提供地RestTemplateBuilder进行RestTemplate的自定义
        RestTemplate restTemplate = builder.basicAuthorization("admin", "123456").build();
        return restTemplate.getForObject("http://localhost:9999/rest/json/school", School.class);
    }

    /**
     * 获取客户端IP地址,需要修改代理服务器配置如下
     * proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
     */
    @GetMapping("/index/ip")
    @ResponseBody
    public String getClientIP(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    System.err.println("ip: " + ip);
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
