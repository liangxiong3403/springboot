package org.liangxiong.springboot.listener;

import org.liangxiong.springboot.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * @author liangxiong
 * @Date:2018-12-09
 * @Time:21:09
 * @Description 自定义测试类执行监听器
 */
public class UserTestExecutionListener extends AbstractTestExecutionListener {

    /**
     * 测试类实例化之前调用
     *
     * @param testContext
     * @throws Exception
     */
    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        User user = applicationContext.getBean(User.class);
        System.err.println("bean: " + user);
    }

    /**
     * 测试方法执行前调用
     *
     * @param testContext
     * @throws Exception
     */
    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.err.println("before test method: " + testContext.getTestMethod());
    }

    /**
     * 测试方法执行后调用
     *
     * @param testContext
     * @throws Exception
     */
    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.err.println("after test method: " + testContext.getTestMethod());
    }

    /**
     * <ul>
     * <li>order只会影响spring.factories</li>
     * <li>@TestExecutionListeners会覆盖spring.factories配置的所有TestExecutionListener</li>
     * <li>修改优先级,数字越小,优先级越高</li>
     * <li>DependencyInjectionTestExecutionListener用于注入Spring管理的Bean,优先级为2000</li>
     * <li>这里优先级设置为最高优先级,表明优先级高于DependencyInjectionTestExecutionListener</li>
     * </ul>
     *
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
