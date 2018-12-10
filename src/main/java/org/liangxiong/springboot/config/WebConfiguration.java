package org.liangxiong.springboot.config;

import org.liangxiong.springboot.component.MiddlewareComponent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liangxiong
 * @Description Web相关配置
 * @Date 2018-10-21
 * @Time 15:46
 */
@Configuration
@EnableConfigurationProperties(MiddlewareComponent.class)
public class WebConfiguration {

    /**
     * 跨域请求配置
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 那些地址需要跨域处理
                registry.addMapping("/**")
                        // 那些origin需要跨域处理
                        .allowedOrigins("http://localhost:8080")
                        // 允许那些方法进行跨域访问
                        .allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS", "HEAD")
                        // 允许哪些请求头进行跨域访问
                        .allowedHeaders("*")
                        // 是否支持用户凭证
                        .allowCredentials(false)
                        // 客户端缓存前一个响应时间
                        .maxAge(3600);
            }
        };
    }

    /**
     * 视图转发配置
     */
    @Bean
    public WebMvcConfigurer viewConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 设置iframe父页面
                registry.addViewController("/iframe/parent").setViewName("iframe-parent");
                // 设置iframe子页面
                registry.addViewController("/iframe/child").setViewName("iframe-child");
            }
        };
    }
}
