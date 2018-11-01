package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.Customer;
import org.liangxiong.springboot.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangxiong
 * @Description MongoDB控制器
 * @Date 2018-11-01
 * @Time 15:02
 */
@RestController
@RequestMapping("/mongodb")
public class MongodbController {

    @Autowired
    private ICustomerService customerService;

    /**
     * 通过用户名查询顾客
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/username/{username}")
    public Customer findCustomerByUsername(@PathVariable String username) {
        return customerService.findCustomerByUsername(username);
    }

    /**
     * 通过性别查询顾客
     *
     * @param sex 性别
     * @return
     */
    @GetMapping("/sex/{sex}")
    public List<Customer> findCustomerBySex(@PathVariable String sex) {
        return customerService.findCustomerBySex(sex);
    }


}
