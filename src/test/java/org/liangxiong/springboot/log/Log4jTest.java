package org.liangxiong.springboot.log;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

import java.net.URL;

/**
 * @author liangxiong
 * @Date:2018-12-02
 * @Time:9:15
 * @Description 测试Log4j功能
 */
public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    /**
     * 生产中可以通过VM参数指定配置文件:-Dlog4j.configuration=log4j-prod.xml
     */
    @Test
    public void testLog4j() {
        // API修改加载地日志配置文件
        URL url = Thread.currentThread().getContextClassLoader().getResource("log4j-api.xml");
        DOMConfigurator.configure(url);
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");
        logger.fatal("fatal...");

        MDC.put("requestURI", "http://liangxiong.org");
        logger.error("hello...");
    }

}
