package org.liangxiong.springboot.service.impl;

import org.liangxiong.springboot.entity.Customer;
import org.liangxiong.springboot.repository.CustomerRepository;
import org.liangxiong.springboot.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangxiong
 * @Description
 * @Date 2018-11-01
 * @Time 15:11
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    @Override
    public List<Customer> findCustomerBySex(String sex) {
        return customerRepository.findCustomerBySex(sex);
    }
}
