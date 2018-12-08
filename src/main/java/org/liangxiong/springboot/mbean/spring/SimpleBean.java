package org.liangxiong.springboot.mbean.spring;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author liangxiong
 * @Date:2018-12-08
 * @Time:12:14
 * @Description 简单Bean, 由Spring管理地MBean
 */
@Component
@ManagedResource(
        objectName = "org.liangxiong.springboot.mbean.spring:type=SimpleBean",
        description = "This is a simple bean managed by spring")
public class SimpleBean {

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 定义MBean暴露属性
     *
     * @return
     */
    @ManagedAttribute(description = "primary key")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManagedAttribute(description = "username")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManagedAttribute(description = "user sex")
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 自定义操作
     *
     * @return
     */
    @ManagedOperation(description = "diy operation")
    public String display() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
