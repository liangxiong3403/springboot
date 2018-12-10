package org.liangxiong.springboot.config;

import org.liangxiong.springboot.websocket.MessageServerEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author liangxiong
 * @Date:2018-11-24
 * @Time:15:30
 * @Description WebSocket配置类
 */
@Profile("prod")
@Configuration
@EnableWebSocket
public class WebSocketConfiguration {

    /**
     * If you want to use @ServerEndpoint in a Spring Boot application that used an embedded container,
     * you must declare a single ServerEndpointExporter @Bean
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 自定义实现地消息端点
     *
     * @return
     */
    @Bean
    public MessageServerEndpoint messageServerEndpoint() {
        return new MessageServerEndpoint();
    }
}
