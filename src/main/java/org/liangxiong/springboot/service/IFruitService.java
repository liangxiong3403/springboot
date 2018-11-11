package org.liangxiong.springboot.service;

import org.liangxiong.springboot.entity.Fruit;

import java.util.List;

/**
 * @author liangxiong
 * @Date:2018-11-10
 * @Time:20:54
 * @Description
 */
public interface IFruitService {

    /**
     * 通过名称查询水果列表
     *
     * @param name 水果名称
     * @return
     */
    List<Fruit> findByName(String name);

    /**
     * 通过id查询数据
     *
     * @param id
     * @return
     */
    Fruit findOne(String id);

    /**
     * 保存数据或者修改数据
     *
     * @param fruit
     * @return
     */
    Fruit save(Fruit fruit);

    /**
     * 删除数据
     *
     * @param id
     */
    void delete(String id);
}
