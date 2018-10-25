package org.liangxiong.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author liangxiong
 * Date:2018-10-03
 * Time:18:57
 * @Description 项目启动类
 */
@SpringBootApplication
@ServletComponentScan("org.liangxiong.springboot.servlet")
public class APP {

    public static void main(String[] args) {
        new SpringApplicationBuilder(APP.class)
                .run(args);
    }
}
