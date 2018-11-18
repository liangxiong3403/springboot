package org.liangxiong.springboot.component;

import org.liangxiong.springboot.annotation.CatNameValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:21:49
 * @Description 自定义Bean的Validator实现
 * @see CatNameValidator
 */
public class CatConstraintValidator implements ConstraintValidator<CatNameValidator, String> {

    private String prefix;

    /**
     * 初始化判断条件
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(CatNameValidator constraintAnnotation) {
        this.prefix = constraintAnnotation.value();
    }

    /**
     * 实际业务逻辑校验参数
     *
     * @param value   用户输入参数
     * @param context 上下文
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 字符串不是以指定前缀开头
        if (!value.startsWith(prefix)) {
            // 不去获取默认message信息
            context.disableDefaultConstraintViolation();
            // 构建消息提示(可以通过数据库读取模板消息)
            ConstraintValidatorContext.ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate("名称必须以\"" + prefix + "\"开头");
            // 如果输入参数不合法,则返回提示消息
            builder.addConstraintViolation();
            // 校验失败
            return false;
        }
        // 校验通过
        return true;
    }
}
