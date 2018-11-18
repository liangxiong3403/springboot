package org.liangxiong.springboot.annotation;

import org.liangxiong.springboot.component.CatConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:18:55
 * @Description 自定义注解, 用于实现Bean Validator功能
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {CatConstraintValidator.class})
public @interface CatNameValidator {

    /**
     * 错误提示消息
     *
     * @return
     */
    String message() default "{liangxiong.Cat.name.validation.constraints.content.message}";

    /**
     * 值
     *
     * @return
     */
    String value();

    /**
     * 定义组
     *
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 负载,携带客户端源数据
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}
