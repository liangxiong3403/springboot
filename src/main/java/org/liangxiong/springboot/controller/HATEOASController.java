package org.liangxiong.springboot.controller;

import org.liangxiong.springboot.entity.School;
import org.liangxiong.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:21:30
 * @Description HATEOAS 相关Demo
 */
@RestController
@RequestMapping("/rest")
public class HATEOASController {

    @Bean
    private School currentSchool() {
        School school = new School();
        school.setSchoolId(1);
        school.setName("init name");
        return school;
    }

    @Autowired
    @Qualifier("currentSchool")
    private School school;

    /**
     * REST 请求返回HTML
     *
     * @return
     */
    @GetMapping("/html/demo")
    public String htmlDemo() {
        return "<html><body>Hello World</body></html>";
    }

    /**
     * JSON响应风格
     *
     * @return
     */
    @GetMapping(value = "/json/school")
    public School getSchoolJSONForm() {
        return school;
    }

    /**
     * HATEOAS demo
     * note：SpringBoot1.4版本无法映射Class级别的@RequestMapping,比如本例地/rest;需要我们升级到1.5版本才行(但是1.5版本不支持velocity)
     *
     * @return
     */
    @GetMapping("/hateoas/school")
    public School getSchoolHATEOASForm(@RequestParam String name) {
        school.setName(name);
        school.add(linkTo(methodOn(HATEOASController.class).getSchoolHATEOASForm(name)).withSelfRel());
        return school;
    }

    /**
     * XML响应风格
     *
     * @return
     */
    @GetMapping(value = "/xml", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public User getUserXMLForm() {
        User user = new User();
        user.setId(1);
        user.setAge(25);
        user.setSex("female");
        user.setUsername("xml");
        return user;
    }

    /**
     * 获取请求中地参数
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/paramFromRequest")
    public String getParamFromRequest(@RequestParam(defaultValue = "鸿钧老祖") String username) {
        return "param: " + username;
    }

    /**
     * 转换数据类型
     *
     * @param age
     * @return
     */
    @GetMapping("/convertParamType")
    public String convertParamType(@RequestParam(name = "age", defaultValue = "0") Integer age) {
        return "param type: " + age.getClass();
    }

    /**
     * 从请求中获取指定header信息
     *
     * @param requestHeader header信息
     * @return
     */
    @GetMapping("/headerFromRequest")
    public String headerFromRequest(@RequestHeader("Accept") String requestHeader) {
        return "header: " + requestHeader;
    }

    @GetMapping("/responseEntity")
    public ResponseEntity<String> responseEntity() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("diyHeader", Arrays.asList("hello,world"));
        ResponseEntity<String> responseEntity = new ResponseEntity("<html><body>Hello,World</body></html>", headers, HttpStatus.OK);
        return responseEntity;
    }

}
