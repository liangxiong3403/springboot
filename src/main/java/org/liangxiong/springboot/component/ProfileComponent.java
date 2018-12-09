package org.liangxiong.springboot.component;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:10:08
 * @Description 通过API调整properties参数加载顺序(修改端口号)
 */
@Component
public class ProfileComponent implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configurableEnvironment = ConfigurableEnvironment.class.cast(environment);
            // 获取可修改地property
            MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
            // 构造参数
            Map<String, Object> source = new HashMap<>(4);
            source.put("server.port", 6666);
            PropertySource propertySource = new MapPropertySource("diy server port", source);
            // 设置最先加载
            mutablePropertySources.addFirst(propertySource);
        }
    }
}
