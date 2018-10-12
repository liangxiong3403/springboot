package org.liangxiong.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author liangxiong
 * Date:2018-10-11
 * Time:21:34
 * @Description 学校实体
 */
@Getter
@Setter
public class School extends ResourceSupport {

    /**
     * 学校id
     */
    private Integer schoolId;

    /**
     * 学校名称
     */
    private String name;

    /**
     * 学校地址
     */
    private String address;

    /**
     * 学生总人数
     */
    private Integer count;
}
