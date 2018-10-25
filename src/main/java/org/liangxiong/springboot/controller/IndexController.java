package org.liangxiong.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liangxiong
 * Date:2018-10-04
 * Time:22:03
 * @Description 模板引擎测试类
 */
@Controller
public class IndexController {

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
}
