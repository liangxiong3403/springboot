package org.liangxiong.springboot.autoconfigure;

import org.liangxiong.springboot.entity.Flower;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author liangxiong
 * @Date:2018-12-16
 * @Time:18:27
 * @Description 自动装配 @{see Dog}类;web环境启动,启动顺序在web容器装配之后!
 */
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "flower", name = "enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureAfter(EmbeddedServletContainerAutoConfiguration.class)
public class FlowerAutoConfiguration {

    /**
     * 自动装配自定义属性第二种方式
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "flower")
    public Flower flower() {
        return new Flower();
    }

}
