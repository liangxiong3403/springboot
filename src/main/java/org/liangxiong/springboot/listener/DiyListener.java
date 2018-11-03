package org.liangxiong.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liangxiong
 * @Date:2018-10-28
 * @Time:19:47
 * @Description
 */
@WebListener
public class DiyListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(DiyListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        request.getServletContext().log("request initialize");
        logger.info("listener port: " + request.getRemotePort());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("request destroy");
    }
}
