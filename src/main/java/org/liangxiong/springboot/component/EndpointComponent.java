package org.liangxiong.springboot.component;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author liangxiong
 * @Description All the registered endpoints should be @Components with HTTP resource annotations
 * @Date 2018-10-22
 * @Time 16:10
 */
@Component
@Path("/hello")
public class EndpointComponent {

    /**
     * API访问路径:@ApplicationPath配置+@Path配置；比如localhost:8086/jersey/hello
     * @return
     */
    @GET
    public String message() {
        return "Hello";
    }
}
