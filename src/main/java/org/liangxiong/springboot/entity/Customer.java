package org.liangxiong.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * @author liangxiong
 * @Description 为MongoDB测试使用地entity
 * @Date 2018-11-01
 * @Time 15:04
 */
@Getter
@Setter
public class Customer {

    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 健康情况
     */
    private boolean health;

}
