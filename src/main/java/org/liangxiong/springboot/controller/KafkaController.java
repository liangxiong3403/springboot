package org.liangxiong.springboot.controller;

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

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private String message;

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    /**
     * 发送消息
     *
     * @param topic 消息主题
     * @param key   消息key
     * @param value 消息value
     */
    @PostMapping
    public Integer sendMessage(@RequestParam String topic, @RequestParam String key, @RequestParam String value) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, value);
        try {
            SendResult<String, String> sendResult = future.get(5, TimeUnit.SECONDS);
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
     * @param message
     */
    @KafkaListener(topics = "test")
    public void processMessage(String message) {
        this.message = message;
    }

    /**
     * 返回Kafka消息
     *
     * @return
     */
    @GetMapping
    public String receiveMessage() {
        return message;
    }
}
