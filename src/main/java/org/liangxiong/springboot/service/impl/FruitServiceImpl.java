package org.liangxiong.springboot.service.impl;

import org.liangxiong.springboot.entity.Fruit;
import org.liangxiong.springboot.repository.FruitRepository;
import org.liangxiong.springboot.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangxiong
 * @Date:2018-11-10
 * @Time:20:55
 * @Description Elasticsearch 相关业务
 */
@Service
public class FruitServiceImpl implements IFruitService {

    ///@Autowired
    private FruitRepository fruitRepository;

    @Override
    public List<Fruit> findByName(String name) {
        return fruitRepository.findByName(name);
    }

    @Override
    public Fruit findOne(String id) {
        ///return fruitRepository.findOne(id);
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        ///return fruitRepository.save(fruit);
        return null;
    }

    @Override
    public void delete(String id) {
        try {
            ///fruitRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
