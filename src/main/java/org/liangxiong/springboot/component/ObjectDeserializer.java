package org.liangxiong.springboot.component;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:10:39
 * @Description 自定义Kafka消息value反序列化
 */
public class ObjectDeserializer implements Deserializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * 反序列化Kafka消息
     *
     * @param topic 主题
     * @param data  消息
     * @return
     */
    @Override
    public Object deserialize(String topic, byte[] data) {
        Object message;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            message = ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return message;
    }

    @Override
    public void close() {

    }
}
