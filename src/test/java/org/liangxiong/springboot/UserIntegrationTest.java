package org.liangxiong.springboot;

import org.junit.*;
import org.junit.runner.RunWith;
import org.liangxiong.springboot.configuration.UserConfiguration;
import org.liangxiong.springboot.entity.User;
import org.liangxiong.springboot.listener.UserTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:20:48
 * @Description {@link User} 集成测试<li>@TestExecutionListeners会覆盖spring.factories配置地所有TestExecutionListener</li>
 */
@RunWith(SpringRunner.class)
@TestPropertySource(properties = "color:red")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, UserTestExecutionListener.class})
@ContextHierarchy({@ContextConfiguration(classes = UserConfiguration.class)})
public class UserIntegrationTest {

    @Autowired
    private User user;

    @Value("${color}")
    private String color;

    @BeforeClass
    public static void beforeClass() {
        System.err.println("beforeClass...");
    }

    @Before
    public void before() {
        System.err.println("before...");
    }

    @Test
    public void testColor() {
        Assert.assertEquals("red", color);
    }

    @Test
    public void testPrimaryUser() {
        Assert.assertEquals(Integer.valueOf(1), user.getId());
        Assert.assertEquals("李白", user.getUsername());
        Assert.assertEquals(Integer.valueOf(88), user.getAge());
        Assert.assertEquals("male", user.getSex());
    }

    @After
    public void after() {
        System.err.println("after...");
    }

    @AfterClass
    public static void afterClass() {
        System.err.println("afterClass...");
    }
}
