package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2018-12-16
 * @Time:18:38
 * @Description 自动装配控制器
 */
@RestController
public class FlowerController {

    private final Flower flower;

    @Autowired
    public FlowerController(Flower flower) {
        this.flower = flower;
    }

    @GetMapping("/flower")
    public Flower getFlower() {
        return flower;
    }
}
