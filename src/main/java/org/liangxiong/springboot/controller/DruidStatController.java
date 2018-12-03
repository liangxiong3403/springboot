package org.liangxiong.springboot.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Description druid监控器
 * @Date 2018-12-03
 * @Time 9:02
 */
@RestController
public class DruidStatController {

    @GetMapping("/druid/stat")
    public Object druidStat() {
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
