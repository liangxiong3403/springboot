package org.liangxiong.springboot.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author liangxiong
 * @Date:2018-12-02
 * @Time:15:22
 * @Description 测试log4j2功能
 */

public class Log4j2Test {

    private static final Logger logger = LogManager.getLogger(Log4j2Test.class);

    @Test
    public void testLog4j2() {
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");
    }
}
