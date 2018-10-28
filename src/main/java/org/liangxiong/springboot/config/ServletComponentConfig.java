package org.liangxiong.springboot.config;

import org.liangxiong.springboot.filter.DiyFilter2;
import org.liangxiong.springboot.servlet.DiyServlet2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.Arrays;

/**
 * @author liangxiong
 * @Date:2018-10-28
 * @Time:20:18
 * @Description 通过SpringBoot配置Servlet
 */
@Configuration
public class ServletComponentConfig {

    /**
     * 通过java API注册自定义Servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new DiyServlet2());
        servletRegistrationBean.setUrlMappings(Arrays.asList("/diyServletByAPI"));
        return servletRegistrationBean;
    }

    /**
     * 通过java API注册自定义Filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DiyFilter2());
        filterRegistrationBean.addUrlPatterns("/diyServletByAPI");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistrationBean;
    }
}
