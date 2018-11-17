package org.liangxiong.springboot.component;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-11-17
 * @Time:10:33
 * @Description 自定义Kafka消息value序列化
 */
public class ObjectSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * 序列化传输
     *
     * @param topic 主题
     * @param data  消息
     * @return
     */
    @Override
    public byte[] serialize(String topic, Object data) {
        byte[] dataArray;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(data);
            dataArray = bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataArray;
    }

    @Override
    public void close() {

    }
}
