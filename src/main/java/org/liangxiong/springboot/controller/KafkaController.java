package org.liangxiong.springboot.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.liangxiong.springboot.entity.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author liangxiong
 * @Date:2018-11-15
 * @Time:19:46
 * @Description Kafka相关控制器
 */
@RestController
@RequestMapping("/kafka/message")
public class KafkaController {

    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private Object object;

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    /**
     * 发送消息
     *
     * @param topic 消息主题
     * @param key   消息key
     * @param value 消息value
     */
    @PostMapping("/simple")
    public Integer sendStringMessage(@RequestParam String topic, @RequestParam String key, @RequestParam String value) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, value);
        try {
            SendResult<String, Object> sendResult = future.get(5, TimeUnit.SECONDS);
            return sendResult.getRecordMetadata().partition();
        } catch (InterruptedException e) {
            logger.error("线程被中断");
        } catch (ExecutionException e) {
            logger.error("任务执行异常");
        } catch (TimeoutException e) {
            logger.error("任务执行超时");
        }
        return null;
    }

    /**
     * 发送消息
     *
     * @param topic 消息主题
     * @param key   消息key
     * @param fruit 消息value
     */
    @PostMapping("/object")
    public Integer sendObjectMessage(@RequestParam String topic, @RequestParam String key, @RequestBody Fruit fruit) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, fruit);
        try {
            SendResult<String, Object> sendResult = future.get(5, TimeUnit.SECONDS);
            return sendResult.getRecordMetadata().partition();
        } catch (InterruptedException e) {
            logger.error("线程被中断");
        } catch (ExecutionException e) {
            logger.error("任务执行异常");
        } catch (TimeoutException e) {
            logger.error("任务执行超时");
        }
        return null;
    }

    /**
     * 监听特定主题的消息
     *
     * @param object
     */
    @KafkaListener(topics = "test")
    public void processMessage(Object object) {
        if (object instanceof ConsumerRecord) {
            this.object = ((ConsumerRecord) object).value();
        }
    }

    /**
     * 返回Kafka消息
     *
     * @return
     */
    @GetMapping
    public Object receiveMessage() {
        return object;
    }
}
