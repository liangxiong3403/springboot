package org.liangxiong.springboot.mbean.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author liangxiong
 * @Date:2018-12-02
 * @Time:20:36
 * @Description 测试Dynamic的MBean
 */
public class DynamicDataDemo {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataDemo.class);

    public static void main(String[] args) {
        // MBean服务器
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        // MBean实例
        DynamicDataMBean dynamicDataMBean = new DynamicDataMBean();
        // ObjectName
        ObjectName objectName = getObjectName(dynamicDataMBean.getClass());
        // 注册MBean
        try {
            mBeanServer.registerMBean(dynamicDataMBean, objectName);
            TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            logger.error("register MBean error");
        }
    }

    private static ObjectName getObjectName(Class<?> claz) {
        try {
            // org.liangxiong.springboot.mbean.standard.SimpleData
            String packageName = claz.getPackage().getName();
            String clazSimpleName = claz.getSimpleName();
            return new ObjectName(packageName + ":type=" + clazSimpleName);
        } catch (MalformedObjectNameException e) {
            logger.error("obtain objectName error");
        }
        return null;
    }
}
