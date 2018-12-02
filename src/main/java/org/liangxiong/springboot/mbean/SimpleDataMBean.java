package org.liangxiong.springboot.mbean;

/**
 * @author liangxiong
 * @Date:2018-12-02
 * @Time:20:30
 * @Description 简单数据MBean
 */
public interface SimpleDataMBean {

    /**
     * 设置数据(property)
     *
     * @param data 数据
     */
    void setData(String data);

    /**
     * 获取数据(property)
     *
     * @return
     */
    String getData();

    /**
     * 展示数据(operation)
     *
     * @return
     */
    String displayData();
}
