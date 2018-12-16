package org.liangxiong.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;

import javax.servlet.ServletContext;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:17:20
 * @Description Servlet相关API测试
 */
public class MockServletAPITest {

    /**
     * {@link ServletContext }
     */
    @Test
    public void testMockServletContext() {
        // 注意:不支持部分Servlet3.0 API
        MockServletContext servletContext = new MockServletContext();
        servletContext.setAttribute("name", "lx");
        Assert.assertEquals("lx", servletContext.getAttribute("name"));
    }

    @Test
    public void testMockServletConfig() {
        MockServletConfig servletConfig = new MockServletConfig();
        servletConfig.addInitParameter("name", "lx");
        Assert.assertEquals("lx", servletConfig.getInitParameter("name"));
    }

}
