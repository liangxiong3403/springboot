package org.liangxiong.springboot.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @author liangxiong
 * @Date:2018-11-11
 * @Time:21:21
 * @Description Cache配置类
 */
@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {
        // 构造CacheManager实例
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        // 初始化存入一个Cache实例并设置Cache名称
        simpleCacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("cache-spring")));
        return simpleCacheManager;
    }
}
