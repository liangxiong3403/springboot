package org.liangxiong.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author liangxiong
 * @Description 测试redis连接
 * @Date 2018-11-01
 * @Time 14:11
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate template;

    /**
     * 根据指定key设置缓存,并返回结果
     *
     * @param key   redis数据结构中的key
     * @param value redis数据结构中的value
     * @return
     */
    @GetMapping("/{key}/{value}")
    public Map<String, String> getKeyFromRedis(@PathVariable String key, @PathVariable String value) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        if (!this.template.hasKey(key)) {
            ops.set(key, value, 30, TimeUnit.SECONDS);
        }
        Map<String, String> data = new HashMap<>(4);
        data.put("key", key);
        data.put("value", ops.get(key));
        return data;
    }
}
