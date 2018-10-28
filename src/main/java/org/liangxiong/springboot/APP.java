package org.liangxiong.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author liangxiong
 * Date:2018-10-03
 * Time:18:57
 * @Description 项目启动类, 可以使用exclude = SecurityAutoConfiguration.class排除Security,Security会屏蔽actuator安全校验
 */
@SpringBootApplication
@ServletComponentScan({"org.liangxiong.springboot.servlet", "org.liangxiong.springboot.filter", "org.liangxiong.springboot.listener"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAuthorizationServer
public class APP extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(APP.class)
                .run(args);
    }

    /**
     * 使用war部署方式使用SpringApplication
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(APP.class);
        return builder;
    }
}
