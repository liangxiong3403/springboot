package org.liangxiong.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.liangxiong.springboot.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2018-12-08
 * @Time:19:56
 * @Description 用于测试SpringBoot读取XML文件
 */
@RestController
@RequestMapping("/dogs")
public class DogController implements EnvironmentAware {

    @Autowired
    private Dog dog;

    @Value("${dog.id:1}")
    private Long id;

    @Value("${dog.name}")
    private String name;

    @Value("${dog.color}")
    private String color;

    @Value("${dog.age}")
    private Integer age;

    /**
     * 品种
     */
    private String type;

    @GetMapping("/{name}")
    public Dog selectDogByName(@PathVariable String name) {
        if (dog.getName().equals(name)) {
            return dog;
        }
        return null;
    }

    @GetMapping("/map")
    public JSONObject getDog() {
        JSONObject data = new JSONObject(8);
        data.put("id", id);
        data.put("name", name);
        data.put("age", age);
        data.put("color", color);
        data.put("type", type);
        return data;
    }

    @Override
    public void setEnvironment(Environment environment) {
        type = environment.getProperty("dog.type");
    }
}
