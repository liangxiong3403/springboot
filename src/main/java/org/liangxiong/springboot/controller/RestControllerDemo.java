package org.liangxiong.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:21:30
 * @Description REST 相关Demo
 */
@RestController
@RequestMapping("/rest")
public class RestControllerDemo {

    /**
     * REST 请求返回HTML
     *
     * @return
     */
    @GetMapping("/html/demo")
    public String htmlDemo() {
        return "<html><body>Hello World</body></html>";
    }

    @GetMapping
    public String test(@RequestParam(required = false, defaultValue = "鸿钧老祖") String username) {
        return "hello," + username;
    }
}
