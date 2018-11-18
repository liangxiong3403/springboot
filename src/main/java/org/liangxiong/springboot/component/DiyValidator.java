package org.liangxiong.springboot.component;

import org.liangxiong.springboot.entity.Cat;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:18:39
 * @Description 自定义Spring的Validator
 */
public class DiyValidator implements Validator {

    /**
     * 保证单例
     */
    private static final DiyValidator validator = new DiyValidator();

    private DiyValidator() {
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static DiyValidator getInstance() {
        return validator;
    }

    /**
     * 需要进行校验地Class类型
     *
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Cat.class.isAssignableFrom(clazz);
    }

    /**
     * 具体校验业务逻辑
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        Cat cat = Cat.class.cast(target);
        if (cat.getAge() < 18 || cat.getAge() > 125) {
            errors.reject("age must greater than 18 and less than 125!", "年龄必须大于18岁并且小于125岁!");
        } else if (!StringUtils.hasText(cat.getName())) {
            errors.reject("name can not be null or empty String!", "名称不能为空或空字符串!");
        } else if (!cat.getName().startsWith("persian-")) {
            errors.reject("name must start with 'persian-'!", "名称必须以波斯-开头!");
        }
    }
}
