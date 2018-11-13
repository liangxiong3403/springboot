package org.liangxiong.springboot.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liangxiong
 * @Description
 * @Date 2018-10-21
 * @Time 11:32
 */
@Getter
@Setter
@AllArgsConstructor
public class CustomErrorType {

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 请求处理结果状态
     */
    private boolean status = false;

}
