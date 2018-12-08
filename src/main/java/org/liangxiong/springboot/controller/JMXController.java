package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.mbean.spring.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2018-12-08
 * @Time:12:22
 * @Description JMX控制器
 */
@RestController
@RequestMapping("/jmx")
public class JMXController {

    @Autowired
    private SimpleBean simpleBean;

    @PostMapping("/bean")
    public SimpleBean initData(@RequestBody SimpleBean data) {
        this.simpleBean.setId(data.getId());
        this.simpleBean.setName(data.getName());
        this.simpleBean.setSex(data.getSex());
        return this.simpleBean;
    }
}
