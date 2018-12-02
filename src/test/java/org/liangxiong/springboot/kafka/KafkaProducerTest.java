package org.liangxiong.springboot.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liangxiong
 * @Date:2018-11-15
 * @Time:19:54
 * @Description Kafka生产者测试类
 */
public class KafkaProducerTest extends Thread {

    private final KafkaProducer<Integer, String> producer;

    /**
     * 消息主题
     */
    private final String topic;

    /**
     * 是否是异步发送
     */
    private final boolean isAsync;

    /**
     * Kafka集群地址
     */
    private static final String CONNECT_STR = "192.168.1.8:9092,192.168.1.9:9092,192.168.1.10:9092";

    public KafkaProducerTest(String topic, boolean isAsync) {
        // 消息主题
        this.topic = topic;
        // 是否异步发送
        this.isAsync = isAsync;
        // 构造生产者参数
        Properties properties = new Properties();
        // kafka集群地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, CONNECT_STR);
        // 客户端id
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducer");
        // 消息确认方式(0,1,-1三种方式)
        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
        // key序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerSerializer");
        // value序列化
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(properties);
    }

    @Override
    public void run() {
        int num = 0;
        while (num < 50) {
            String message = "message_" + num;
            System.out.println("begin send message: " + message);
            // 判断消息发送模式(同步/异步)
            if (isAsync) {
                producer.send(new ProducerRecord(topic, num, message), (metadata, exception) -> {
                    if (null != metadata) {
                        System.out.println(
                                "async-offset: " + metadata.offset() + "->partition: " + metadata.partition());
                    }
                });
            } else {
                try {
                    RecordMetadata metadata = producer.send(new ProducerRecord<>(topic, num, message)).get();
                    if (null != metadata) {
                        System.out
                                .println("sync-offset: " + metadata.offset() + "->partition: " + metadata.partition());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            num++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new KafkaProducerTest("test", true);
        thread.start();
    }
}
