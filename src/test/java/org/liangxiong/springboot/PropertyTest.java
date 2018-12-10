package org.liangxiong.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:16:50
 * @Description 环境测试
 */
public class PropertyTest {

    @Test
    public void testSystemProperty() {
        String country = System.getProperty("user.country");
        Assert.assertNotNull(country);
        Assert.assertEquals("CN", country);
    }

    @Test
    public void testEnvironmentProperty() {
        MockEnvironment environment = new MockEnvironment();
        environment.setProperty("USERDOMAIN", "lx3403");
        Assert.assertEquals("lx3403", environment.getProperty("USERDOMAIN"));
    }

    @Test
    public void testManagementSecureEnabled() {
        String managment_key = "management.security.enabled";
        MockEnvironment environment = new MockEnvironment();
        environment.setProperty(managment_key, "true");
        Assert.assertTrue(environment.getProperty(managment_key, boolean.class));
    }

    @Test
    public void testManagementSecureDisabled() {
        String managment_key = "management.security.enabled";
        MockEnvironment environment = new MockEnvironment();
        environment.setProperty(managment_key, "false");
        Assert.assertFalse(environment.getProperty(managment_key, boolean.class));
    }
}
