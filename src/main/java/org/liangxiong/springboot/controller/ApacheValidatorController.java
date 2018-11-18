package org.liangxiong.springboot.controller;

import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:16:53
 * @Description Apache Validator校验数据
 */
@RestController
@RequestMapping("/apache/validator")
public class ApacheValidatorController {

    /**
     * 验证IP地址
     *
     * @param inetAddress IP地址
     * @return
     */
    @GetMapping("/inetAddress")
    public String validateInetAddress(@RequestParam String inetAddress) {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        if (validator.isValid(inetAddress)) {
            return "合法IP地址!";
        }
        return "非法IP地址!";
    }

    /**
     * 验证Email地址
     *
     * @param emailAddress Email地址
     * @return
     */
    @GetMapping("/email")
    public String validateEmail(@RequestParam String emailAddress) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(emailAddress)) {
            return "合法Email地址!";
        }
        return "非法Email地址!";
    }

    /**
     * 验证输入日期字符串
     *
     * @param dateStr 日期字符串
     * @return
     */
    @GetMapping("/date")
    public String validateDate(@RequestParam String dateStr) {
        DateValidator validator = DateValidator.getInstance();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (validator.isValid(dateStr, pattern, Locale.CHINA)) {
            return "输入日期合法!";
        }
        return "输入日期非法!";
    }
}
