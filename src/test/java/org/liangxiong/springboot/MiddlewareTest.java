package org.liangxiong.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangxiong.springboot.component.MiddlewareComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:22:55
 * @Description 测试获取自定义POJO封装地参数值
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
public class MiddlewareTest {

    @Autowired
    private MiddlewareComponent middlewareComponent;

    @Test
    public void testGetMiddlewareProperty() {
        Assert.assertEquals("Tomcat", middlewareComponent.getFirstName());
    }
}
