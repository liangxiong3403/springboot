package org.liangxiong.springboot.service.impl;

import org.liangxiong.springboot.entity.User;
import org.liangxiong.springboot.repository.UserRepository;
import org.liangxiong.springboot.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:21:05
 * @Description 用户业务层
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> entities) {
        return userRepository.save(entities);
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return userRepository.exists(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAll(Iterable<Integer> ids) {
        return userRepository.findAll(ids);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<? extends User> entities) {
        userRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
