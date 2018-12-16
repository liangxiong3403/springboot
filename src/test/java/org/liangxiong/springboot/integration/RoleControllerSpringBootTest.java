package org.liangxiong.springboot.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangxiong.springboot.controller.IntegrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author liangxiong
 * @Date:2018-12-10
 * @Time:20:31
 * @Description
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = IntegrationController.class)
public class RoleControllerSpringBootTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 测试输入参数是否合法(需要关闭@ImportResource和@EnableAuthorizationServer)
     */
    @Test
    public void testInputData() {
        try {
            String param = "xiaobai";
            String expected = "text/plain;charset=UTF-8";
            String result = mockMvc.perform(get("/test/integration").accept(MediaType.TEXT_PLAIN).content(param))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentType();
            Assert.assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
