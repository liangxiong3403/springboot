package org.liangxiong.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liangxiong
 * @Description 自定义properties, PropertySource定义properties文件位置;ConfigurationProperties配置属性前缀
 * @Date 2018-10-15
 * @Time 16:18
 */
@Getter
@Setter
@Configuration
@Validated
@ConfigurationProperties("lx")
@PropertySource("classpath:diy.properties")
public class DiyConfigProperties {

    /**
     * 姓名
     */
    @NotNull
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 站点
     */
    private List<String> websites = new ArrayList<>(10);
}
