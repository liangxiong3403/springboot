package org.liangxiong.springboot;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liangxiong.springboot.controller.SpringValidatorController;
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
@WebMvcTest(controllers = {SpringValidatorController.class})
public class RoleControllerSpringBootTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * TODO
     * 测试输入参数是否合法
     */
    @Test
    @Ignore("dependency security")
    public void testInputData() {
        try {
            mockMvc.perform(get("/spring/validator/cat").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
