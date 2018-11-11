package org.liangxiong.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-11-11
 * @Time:21:06
 * @Description Cache控制器
 */
@RestController
@RequestMapping("/cache/spring")
public class CacheController {

    @Autowired
    @Qualifier("simpleCacheManager")
    private CacheManager cacheManager;

    @PostMapping
    public Map<String, String> saveCache(@RequestParam String key, @RequestParam String value) {
        Cache cache = cacheManager.getCache("cache-spring");
        cache.put(key, value);
        Map<String, String> result = new HashMap<>(4);
        result.put(key, value);
        return result;
    }
}
