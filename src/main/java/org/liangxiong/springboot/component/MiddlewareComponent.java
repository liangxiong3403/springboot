package org.liangxiong.springboot.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liangxiong
 * @Description This can be particularly useful when you want to bind properties to third-party components that are outside of your control.
 * @Date 2018-10-16
 * @Time 16:42
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "middleware")
public class MiddlewareComponent {

    /**
     * 名字
     */
    private String firstName;

    /**
     * 姓氏
     */
    private String lastName;
}
