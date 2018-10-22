package org.liangxiong.springboot.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.liangxiong.springboot.component.EndpointComponent;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * @author liangxiong
 * @Description register all the endpoint;@ApplicationPath设置jersey访问的根路径
 * @Date 2018-10-22
 * @Time 16:09
 */
@Component
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(EndpointComponent.class);
    }

}
