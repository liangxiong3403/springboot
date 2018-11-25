package org.liangxiong.springboot.webservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author liangxiong
 * @Date:2018-11-25
 * @Time:16:31
 * @Description WebService 配置类
 * @see WsConfigurerAdapter
 * @see WebMvcConfigurerAdapter
 */
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

    /**
     * 暴露schema
     *
     * @return
     */
    @Bean
    public XsdSchema elephantXsdSchema() {
        return new SimpleXsdSchema(new ClassPathResource("META-INF/schemas/elephant.xsd"));
    }

    /**
     * 暴露WSDL
     *
     * @return
     */
    @Bean("elephant")
    @Autowired
    public Wsdl11Definition elephantWsdl11Definition(XsdSchema elephantXsdSchema) {
        DefaultWsdl11Definition elephantWsdl11Definition = new DefaultWsdl11Definition();
        elephantWsdl11Definition.setPortTypeName("ElephantServicePort");
        // 服务接口路径名称
        elephantWsdl11Definition.setLocationUri("/web-service");
        // 设置xsd命名空间
        elephantWsdl11Definition.setTargetNamespace("http://liangxiong.org/schemas");
        // 设置xsd约束
        elephantWsdl11Definition.setSchema(elephantXsdSchema);
        return elephantWsdl11Definition;
    }

}
