package org.liangxiong.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * @author liangxiong
 * @Date:2018-11-07
 * @Time:21:39
 * @Description 角色监听器
 */
public class RoleListener {

    private static final Logger logger = LoggerFactory.getLogger(RoleListener.class);

    /**
     * 持久化之前
     *
     * @param source
     */
    @PrePersist
    public void prePersist(Object source) {
        logger.info("prePersist: " + source);
    }

    /**
     * 持久化之后
     *
     * @param source
     */
    @PostPersist
    public void postPersist(Object source) {
        logger.info("postPersist: " + source);
    }
}
