package org.liangxiong.springboot.repository;

import org.liangxiong.springboot.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangxiong
 * @Description
 * @Date 2018-11-01
 * @Time 15:08
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

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
