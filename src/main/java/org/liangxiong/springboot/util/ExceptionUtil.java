package org.liangxiong.springboot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author liangxiong
 * @Description 异常工具类
 * @Date 2018-10-21
 * @Time 14:30
 */
public class ExceptionUtil {

    /**
     * 获取异常堆栈信息
     *
     * @param e 异常类型
     * @return
     */
    public static String getFullStackTrace(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
