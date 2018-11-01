package org.liangxiong.springboot.service;

import org.liangxiong.springboot.entity.Customer;

import java.util.List;

/**
 * @author liangxiong
 * @Description
 * @Date 2018-11-01
 * @Time 15:11
 */
public interface ICustomerService {

    /**
     * 通过用户名查询顾客
     *
     * @param username 用户名
     * @return
     */
    Customer findCustomerByUsername(String username);

    /**
     * 通过性别查询顾客
     *
     * @param sex 性别
     * @return
     */
    List<Customer> findCustomerBySex(String sex);
}
