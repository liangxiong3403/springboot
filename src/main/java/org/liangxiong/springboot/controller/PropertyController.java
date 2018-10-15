package org.liangxiong.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Description 获取自定义属性控制器
 * @Date 2018-10-15
 * @Time 16:20
 */
@RestController
@RequestMapping("/property")
public class PropertyController {

    /**
     * 注入自定义属性值:lx.name
     */
    @Value("${lx.name}")
    private String name;

    /**
     * 注入自定义属性值:lx.sex,如果不存在则设置默认值male
     */
    @Value("${lx.sex:male}")
    private String sex;

    /**
     * 注入自定义属性值:lx.favorite.numbers
     */
    @Value("${lx.favorite.numbers}")
    private String[] numbers;

    /**
     * 获取姓名
     *
     * @return
     */
    @GetMapping("/name")
    public String getNameOfDiyProperty() {
        return name;
    }

    /**
     * 获取性别
     *
     * @return
     */
    @GetMapping("/sex")
    public String getSexOfDiyProperty() {
        return sex;
    }

    /**
     * 获取数组
     *
     * @return
     */
    @GetMapping("/numbers")
    public String[] getNumbersOfDiyProperty() {
        return numbers;
    }
}
