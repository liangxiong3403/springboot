package org.liangxiong.springboot.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liangxiong
 * @Date:2018-12-08
 * @Time:19:53
 * @Description 用于测试SpringBoot读取XML文件
 */
@Getter
@Setter
public class Dog {

    /**
     * 姓名
     */
    private String name;

    /**
     * 颜色
     */
    private String color;

    /**
     * 年龄
     */
    private Integer age;
}
