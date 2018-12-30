package org.liangxiong.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.springsupport.SimpleJavaMailSpringSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liangxiong
 * @Description 邮件发送测试
 * @Description 注意:simple-java-mail邮件模块未兼容YAML文件格式,必须使用properties格式配置参数
 * @Description 注意:@Import(SimpleJavaMailSpringSupport.class)实际会以@Bean的方式注入配置,可能与项目中配置的@Bean冲突,从而导致NoUniqueBeanDefinitionException
 * @Date 2018-11-08
 * @Time 11:37
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import(SimpleJavaMailSpringSupport.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SendEmailTest {

    @Autowired
    private Mailer mailer;

    @Test
    public void testSendEmail() {
        // 构建邮件主题
        Email email = EmailBuilder.startingBlank()
                .from("liangxiong", "1071608617@qq.com")
                .to("Google", "scliangxiong@gmail.com")
                .to("Tencent", "1720711743@qq.com")
                .withSubject("Test 3rd party mail API!")
                .withHTMLText("<p style=\"color:blue\">Invoke 3rd party API to send email!</p>")
                .buildEmail();
        // 发送邮件
        mailer.sendMail(email);
    }
}
