package org.liangxiong.springboot.mbean;

/**
 * @author liangxiong
 * @Date:2018-12-02
 * @Time:20:34
 * @Description 简单数据 MBean实现类.(实现类和接口必须处于同一级别包下,否则报错:NotCompliantMBeanException)
 */
public class SimpleData implements SimpleDataMBean {

    private String data;

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public String displayData() {
        return this.data;
    }
}
