package org.liangxiong.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.liangxiong.springboot.entity.Fruit;
import org.liangxiong.springboot.service.IFruitService;
import org.liangxiong.springboot.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author liangxiong
 * @Date:2018-11-10
 * @Time:19:16
 * @Description Elasticsearch相关控制器
 */
@RestController
@RequestMapping("/elasticsearch/fruits")
public class ElasticsearchController {

    /**
     * 多态写法,兼容JPA,Mongo等
     */
    @Autowired
    private IFruitService fruitService;

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchController.class);

    /**
     * 通过索引id查询数据
     *
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public Fruit selectFruitById(@PathVariable String id) {
        return fruitService.findOne(id);
    }

    /**
     * 通过名称查询水果列表
     *
     * @param name 水果名称
     * @return
     */
    @GetMapping("/name/{name}")
    public List<Fruit> findByName(@PathVariable String name) {
        return fruitService.findByName(name);
    }

    /**
     * 添加数据
     *
     * @param id
     * @param fruit 水果
     * @return
     */
    @PostMapping("/id/{id}")
    public Fruit saveFruit(@PathVariable String id, @RequestBody Fruit fruit) {
        fruit.setId(id);
        fruit.setDate(new Date(System.currentTimeMillis()));
        return fruitService.save(fruit);
    }

    /**
     * 修改数据
     *
     * @param fruit 水果
     * @return
     */
    @PutMapping
    public Fruit updateFruit(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    /**
     * 根据索引删除数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("/id/{id}")
    public JSONObject deleteFruit(@PathVariable String id) {
        try {
            fruitService.delete(id);
            return MessageUtil.getExecuteResult(Boolean.TRUE);
        } catch (Exception e) {
            logger.error("删除数据失败");
        }
        return MessageUtil.getExecuteResult(Boolean.FALSE);
    }

}
