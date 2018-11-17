package org.liangxiong.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangxiong
 * @Date:2018-11-10
 * @Time:19:07
 * @Description 水果实体, 为Elasticsearch测试使用;indexName为索引名称
 */
@Getter
@Setter
@ToString
///@Document(indexName = "fruit", type = "fruit")
public class Fruit implements Serializable {

    private static final long serialVersionUID = 6021879582507799883L;

    private String id;

    /**
     * 水果名称
     */
    private String name;

    /**
     * 产地
     */
    private String home;

    /**
     * 生产时间
     */
    private Date date;

    /**
     * 价格
     */
    private Double price;
}
