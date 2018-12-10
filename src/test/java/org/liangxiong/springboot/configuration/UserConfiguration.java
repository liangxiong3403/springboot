package org.liangxiong.springboot.configuration;

import org.liangxiong.springboot.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:20:45
 * @Description {@link User}配置类
 */
@Configuration
public class UserConfiguration {

    @Bean
    @Primary
    public User user() {
        User user = new User();
        user.setId(1);
        user.setUsername("李白");
        user.setAge(88);
        user.setSex("male");
        return user;
    }
}
