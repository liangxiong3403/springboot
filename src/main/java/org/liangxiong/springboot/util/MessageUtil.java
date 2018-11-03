package org.liangxiong.springboot.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liangxiong
 * @Date:2018-11-03
 * @Time:10:14
 * @Description 消息相关工具类
 */
public class MessageUtil {

    public static JSONObject getExecuteResult(Object param) {
        JSONObject result = new JSONObject(4);
        if (param instanceof Boolean) {
            Boolean status = (Boolean) param;
            if (status) {
                result.put("success", Boolean.TRUE);
                result.put("message", "操作成功!");
            } else {
                result.put("success", Boolean.FALSE);
                result.put("message", "操作失败!");
            }
        } else if (param instanceof Integer) {
            Integer status = (Integer) param;
            if (status > 0) {
                result.put("success", Boolean.TRUE);
                result.put("message", "操作成功!");
            } else {
                result.put("success", Boolean.FALSE);
                result.put("message", "操作失败!");
            }
        }
        return result;
    }
}
