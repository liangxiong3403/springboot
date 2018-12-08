package org.liangxiong.springboot.mbean.standard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liangxiong
 * @Date:2018-12-02
 * @Time:20:34
 * @Description 标准MBean.(实现类和接口必须处于同一级别包下,否则报错:NotCompliantMBeanException)
 */
public class SimpleData extends NotificationBroadcasterSupport implements SimpleDataMBean, NotificationListener, NotificationFilter {

    /**
     * 新的数据
     */
    private String data;

    private static final AtomicLong sequenceNumber = new AtomicLong();

    /**
     * 注册通知监听器,监听发布地事件
     */
    public SimpleData() {
        // 调用父类
        this.addNotificationListener(this, this, null);
    }

    private static final Logger logger = LoggerFactory.getLogger(SimpleData.class);

    @Override
    public void setData(String data) {
        // 获取旧地值
        String oldData = this.data;
        // 设置新地值
        this.data = data;
        // 实例化属性改变通知器
        Notification notification = new AttributeChangeNotification(this, sequenceNumber.incrementAndGet(), System.currentTimeMillis(), "data has benn changed from " + oldData + " to " + data, "data", data.getClass().getName(), oldData, data);
        // 发送事件(核心逻辑)
        sendNotification(notification);
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public String displayData() {
        return this.data;
    }

    /**
     * 过滤指定通知事件
     *
     * @param notification
     * @return
     */
    @Override
    public boolean isNotificationEnabled(Notification notification) {
        String attributeName = "data";
        if (AttributeChangeNotification.class.isAssignableFrom(notification.getClass())) {
            // 通知事件类型匹配
            AttributeChangeNotification attributeChangeNotification = AttributeChangeNotification.class.cast(notification);
            if (attributeName.equals(attributeChangeNotification.getAttributeName())) {
                // 监听属性名称匹配
                return true;
            }
        }
        return false;
    }

    /**
     * 处理通知事件逻辑
     *
     * @param notification 通知事件
     * @param handback
     */
    @Override
    public void handleNotification(Notification notification, Object handback) {
        AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;
        String oldData = (String) attributeChangeNotification.getOldValue();
        String newData = (String) attributeChangeNotification.getNewValue();
        logger.info("AttributeChangeNotification oldData : {}, newData: {}", oldData, newData);
    }

    /**
     * 暴露通知信息(否则需要我们自己去jConsole订阅通知)
     *
     * @return
     */
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[]{new MBeanNotificationInfo(new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE}, this.getClass().getName(), "attribute changed")};
    }
}
