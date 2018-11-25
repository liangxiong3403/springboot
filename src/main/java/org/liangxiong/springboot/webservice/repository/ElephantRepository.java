package org.liangxiong.springboot.webservice.repository;

import org.liangxiong.springboot.webservice.entity.Elephant;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-11-25
 * @Time:16:06
 * @Description Elephant仓库服务
 */
@Repository
public class ElephantRepository {

    private static Map<Long, Elephant> data = new HashMap<>(8);

    /**
     * 初始化数据(生产中走数据库)
     */
    @PostConstruct
    private void initData() {
        data.put(1L, createElephant(1L, "非洲象", 60));
        data.put(2L, createElephant(2L, "森林象", 80));
        data.put(3L, createElephant(3L, "印度象", 30));
    }

    /**
     * 创建实例,为了不修改Elephant源码
     *
     * @param id   主键
     * @param name 名称
     * @param age  年龄
     * @return
     */
    private Elephant createElephant(long id, String name, Integer age) {
        Elephant elephant = new Elephant();
        elephant.setId(id);
        elephant.setName(name);
        elephant.setAge(age);
        return elephant;
    }

    /**
     * 查询接口
     *
     * @param id 主键
     * @return
     */
    public Elephant selectElephantById(long id) {
        return data.get(id);
    }
}
