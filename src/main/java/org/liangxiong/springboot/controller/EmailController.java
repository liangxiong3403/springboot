package org.liangxiong.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.liangxiong.springboot.util.MessageUtil;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Description 邮件控制器
 * @Date 2018-11-08
 * @Time 14:24
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Bean
    public Mailer mailer() {
        return MailerBuilder
                .withSMTPServer("smtp.qq.com", 25, "1071608617@qq.com", "zhrckilpzqjbbdbj")
                .buildMailer();
    }

    @Autowired
    private Mailer mailer;

    /**
     * 发送邮件
     *
     * @param fromAddress 发件人地址
     * @param toAddress   收件人地址(也可以是数组)
     * @return
     */
    @GetMapping
    public JSONObject sendEmail(@RequestParam String fromAddress, @RequestParam String toAddress) {
        // 构建邮件主题
        Email email = EmailBuilder.startingBlank()
                .from("liangxiong", fromAddress)
                .to("Tencent", toAddress)
                .withSubject("Test 3rd party mail API!")
                .withHTMLText("<p style=\"color:blue\">Invoke 3rd party API to send email!</p>")
                .buildEmail();
        try {
            mailer.sendMail(email);
            return MessageUtil.getExecuteResult(Boolean.TRUE);
        } catch (Exception e) {
            logger.error("send email failed!");
        }
        return MessageUtil.getExecuteResult(Boolean.FALSE);
    }
}
