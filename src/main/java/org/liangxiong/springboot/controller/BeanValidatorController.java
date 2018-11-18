package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.Cat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:20:14
 * @Description Bean Validator控制器
 */
@RestController
@RequestMapping("/bean/validator")
public class BeanValidatorController {

    /**
     * Bean Validator验证方式
     *
     * @param cat
     * @return
     */
    @PostMapping("/cat")
    public String validateCat(@RequestBody @Valid Cat cat) {
        return "valid user";
    }
}
