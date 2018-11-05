package org.liangxiong.springboot;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangxiong.springboot.entity.School;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author liangxiong
 * Date:2018-10-28
 * Time:10:11
 * @Description 测试RestTemplate, TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientTest {

    @Test
    @Ignore("wait for completing")
    public void testClient() {
        RestTemplate template = new RestTemplate();
        School person = template.getForObject("http://localhost:9999/rest/json/school", School.class);
        System.out.println("person: " + person);

    }

}