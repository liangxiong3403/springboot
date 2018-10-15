package org.liangxiong.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author liangxiong
 * @Description 自定义properties, PropertySource定义properties文件位置;ConfigurationProperties配置属性前缀
 * @Date 2018-10-15
 * @Time 16:18
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("lx")
@PropertySource("classpath:diy.properties")
public class DiyConfigProperties {

    private String name;

    private int age;
}
