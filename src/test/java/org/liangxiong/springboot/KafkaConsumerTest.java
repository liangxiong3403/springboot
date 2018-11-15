package org.liangxiong.springboot;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author liangxiong
 * @Date:2018-11-15
 * @Time:19:55
 * @Description Kafka消费者测试类
 */
public class KafkaConsumerTest extends Thread {

    private final KafkaConsumer<Integer, String> consumer;

    /**
     * Kafka集群地址
     */
    private static final String CONNECT_STR = "192.168.1.8:9092,192.168.1.9:9092,192.168.1.10:9092";

    public KafkaConsumerTest(String topic) {
        // 配置消费者参数
        Properties properties = new Properties();
        // kafka集群地址
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, CONNECT_STR);
        // 设置消费者所属group
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumer");
        // 设置自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        // 设置自动提交间隔时间
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 设置key反序列化类
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerDeserializer");
        // 设置value反序列化类
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer(properties);
        // 订阅topic
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public void run() {
        while (true) {
            // 拉取消息
            ConsumerRecords<Integer, String> poll = consumer.poll(1000);
            for (ConsumerRecord<Integer, String> consumerRecord : poll) {
                System.out.println("topic: " + consumerRecord.topic() + ", key: " + consumerRecord.key() + ", value: " + consumerRecord.value());
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new KafkaConsumerTest("test");
        thread.start();
    }

}
