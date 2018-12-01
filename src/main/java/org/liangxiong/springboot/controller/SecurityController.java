package org.liangxiong.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liangxiong
 * @Date:2018-11-27
 * @Time:21:32
 * @Description 安全相关控制器
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 错误页面
     *
     * @return
     */
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/process")
    public void success() {
        System.out.println("csrf...");
    }

    @GetMapping("/xss")
    public String xss(Model model) {
        // 模拟XSS代码(Thymeleaf已经内部处理了XSS)
        model.addAttribute("jsCode", "<script>alert('XSS attack');</script>");
        // Html代码
        model.addAttribute("htmlCode", "<p>hello,world</p>");
        return "xss";
    }

}
