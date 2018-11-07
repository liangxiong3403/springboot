package org.liangxiong.springboot.component;

import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangxiong
 * @Description 编程式方式定制化配置server
 * @Date 2018-10-25
 * @Time 11:22
 */
@Component
public class CustomizationServer implements EmbeddedServletContainerCustomizer {

    /**
     * 方式一:实现接口,覆写方法
     *
     * @param container 容器
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        // 修改容器端口,优先级高于application.properties
        container.setPort(9999);
        // 解决客户端404错误,出现404错误时访问/404请求
        ///ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        ///Set<ErrorPage> errorPages = new HashSet<>(4);
        ///errorPages.add(errorPage);
        ///container.setErrorPages(errorPages);
        if (container instanceof TomcatEmbeddedServletContainerFactory) {
            TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);
            // 修改Tomcat的HTTP协议
            factory.setProtocol(Http11Nio2Protocol .class.getName());
        }
    }

    /**
     * 方式二:注册一个Spring Bean,无法扫描servlet注解
     *
     * @return
     */
    /*@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        // 修改容器端口,优先级低于application.properties
        factory.setPort(8888);
        // 解决客户端404错误,出现404错误时访问/404请求
        ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        Set<ErrorPage> errorPages = new HashSet<>(4);
        errorPages.add(errorPage);
        factory.setErrorPages(errorPages);
        return factory;
    }*/
}
