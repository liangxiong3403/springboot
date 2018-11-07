package org.liangxiong.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangxiong.springboot.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author liangxiong
 * Date:2018-10-28
 * Time:10:11
 * @Description 测试RestTemplate
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientTest {

    @Autowired
    private RestTemplateBuilder builder;

    @Test
    public void testClient() {
        // 获取带有认证信息地restTemplate
        RestTemplate restTemplate = builder.basicAuthorization("admin", "123456").build();
        School person = restTemplate.getForObject("http://localhost:9999/rest/json/school", School.class);
        Assert.assertEquals("init name", person.getName());
    }

}
