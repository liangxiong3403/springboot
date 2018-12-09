package org.liangxiong.springboot.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:10:42
 * @Description 自定义应用监听器, 指定配置文件加载顺序
 */
public class CustomizeSpringBootApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        // 获取应用环境
        ConfigurableEnvironment configurableEnvironment = event.getEnvironment();
        // 获取可修改地property
        MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
        // 构造参数
        Map<String, Object> source = new HashMap<>(4);
        // 注意:端口修改配置优先级低于org.liangxiong.springboot.component.CustomizationServer,高于application.properties
        source.put("server.port", 8888);
        source.put("spring.profiles.include", "test");
        PropertySource propertySource = new MapPropertySource("update properties based on listener", source);
        // 设置最先加载
        mutablePropertySources.addFirst(propertySource);
    }
}
