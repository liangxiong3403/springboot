package org.liangxiong.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.liangxiong.springboot.annotation.CatNameValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:18:53
 * @Description 动物猫实体, 用户Validator测试
 */
@Getter
@Setter
public class Cat {

    /**
     * 姓名
     */
    @Size(min = 2, max = 8, message = "{liangxiong.Cat.validation.constraints.Size.message}")
    @CatNameValidator(value = "lx-")
    private String name;

    /**
     * 年龄
     */
    @Min(value = 1, message = "最小年龄不能小于1岁")
    @Max(value = 125, message = "最大年龄不能大于125岁")
    private Integer age;
}
