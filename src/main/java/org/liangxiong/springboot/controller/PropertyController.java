package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.component.MiddlewareComponent;
import org.liangxiong.springboot.config.DiyConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangxiong
 * @Description 获取自定义属性控制器
 * @Date 2018-10-15
 * @Time 16:20
 */
@RestController
@EnableConfigurationProperties(MiddlewareComponent.class)
@RequestMapping("/property")
public class PropertyController {

    /**
     * 注入自定义属性值:lx.name
     */
    @Value("${lx.name:undefined}")
    private String name;

    /**
     * 注入自定义属性值:lx.sex,如果不存在则设置默认值male
     */
    @Value("${lx.sex:male}")
    private String sex;

    /**
     * 注入自定义属性值:lx.favorite.numbers
     */
    @Value("${lx.favorite.numbers}")
    private String[] numbers;

    /**
     * 获取uuid
     */
    @Value("${lx.uuid}")
    private String uuid;

    /**
     * 获取范围内随机值
     */
    @Value("${lx.number.in.range}")
    private int rangeNumber;

    /**
     * 自定义POJO接收配置参数
     */
    @Autowired
    private MiddlewareComponent middlewareComponent;

    /**
     * 获取站点列表
     */
    @Autowired
    private DiyConfigProperties diyConfigProperties;

    /**
     * 获取姓名
     *
     * @return
     */
    @GetMapping("/name")
    public String getNameOfDiyProperty() {
        return name;
    }

    /**
     * 获取姓名
     *
     * @return
     */
    @GetMapping("/middleware")
    public MiddlewareComponent middlewareComponent() {
        return this.middlewareComponent;
    }

    /**
     * 获取性别
     *
     * @return
     */
    @GetMapping("/sex")
    public String getSexOfDiyProperty() {
        return sex;
    }

    /**
     * 获取数组
     *
     * @return
     */
    @GetMapping("/numbers")
    public String[] getNumbersOfDiyProperty() {
        return numbers;
    }

    /**
     * 获取uuid
     *
     * @return
     */
    @GetMapping("/uuid")
    public String getUUID() {
        return uuid;
    }

    /**
     * 获取某个范围内地随机值
     *
     * @return
     */
    @GetMapping("/rangeNumber")
    public int getRangeNumber() {
        return rangeNumber;
    }

    /**
     * 获取站点列表
     *
     * @return
     */
    @GetMapping("/websites")
    public List<String> getWebsites() {
        return diyConfigProperties.getWebsites();
    }
}
