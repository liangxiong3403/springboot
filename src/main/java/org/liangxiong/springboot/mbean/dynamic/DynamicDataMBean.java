package org.liangxiong.springboot.mbean.dynamic;

import javax.management.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangxiong
 * @Date:2018-12-08
 * @Time:11:06
 * @Description 动态MBean, 动态定义MBean结构
 * <ul>
 * <li>定义属性data</li>
 * <li>定义操作displayData</li>
 * </ul>
 */
public class DynamicDataMBean implements DynamicMBean {

    private Map<String, Object> data = new ConcurrentHashMap<>(8);

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        return data.get(attribute);
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        data.put(attribute.getName(), attribute.getValue());
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        return null;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return null;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        // 类似AOP调用
        String methodName = "displayData";
        if (methodName.equals(actionName)) {
            return data;
        }
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanInfo mBeanInfo = new MBeanInfo(this.getClass().getName(), "dynamic mbean",
            of(new MBeanAttributeInfo("data", String.class.getName(), "dynamic attribute", true, true, false)),
            of(new MBeanConstructorInfo(this.getClass().getSimpleName(), "default constructor", new MBeanParameterInfo[]{})),
            of(new MBeanOperationInfo("displayData", "diy operation", new MBeanParameterInfo[]{}, String.class.getName(), MBeanOperationInfo.ACTION)),
            new MBeanNotificationInfo[0]);
        return mBeanInfo;
    }

    /**
     * 获取指定类型数组
     *
     * @param array
     * @param <T>
     * @return
     */
    private static <T> T[] of(T... array) {
        return array;
    }
}
