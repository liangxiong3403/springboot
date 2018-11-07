package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.User;
import org.liangxiong.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:21:09
 * @Description 用户控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 通过id获取用户
     *
     * @param userId 用户d
     * @return
     */
    @GetMapping("/{userId}")
    public User findOne(@PathVariable("userId") Integer userId) {
        return userService.findOne(userId);
    }

}
