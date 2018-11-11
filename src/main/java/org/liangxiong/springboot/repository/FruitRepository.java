package org.liangxiong.springboot.repository;

import org.liangxiong.springboot.entity.Fruit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangxiong
 * @Date:2018-11-10
 * @Time:19:08
 * @Description Fruit的Repository, Elasticsearch测试使用
 */
@Repository
@Qualifier("fruitRepository")
public interface FruitRepository/* extends ElasticsearchRepository<Fruit, String> */ {

    /**
     * 通过名称查询水果列表
     *
     * @param name 水果名称
     * @return
     */
    List<Fruit> findByName(String name);
}
