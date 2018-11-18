package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.component.DiyValidator;
import org.liangxiong.springboot.entity.Cat;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:19:13
 * @Description Spring Validator相关控制器
 */
@RestController
@RequestMapping("/spring/validator")
public class SpringValidatorController {

    /**
     * 校验数据
     */
    @PostMapping("/cat")
    public void validateCat(@RequestBody Cat cat) {
        DiyValidator validator = DiyValidator.getInstance();
        if (validator.supports(cat.getClass())) {
            validator.validate(cat, new BindException(SpringValidatorController.class, "Cat.class"));
        }
    }
}
