package org.liangxiong.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.liangxiong.springboot.entity.Role;
import org.liangxiong.springboot.service.IRoleService;
import org.liangxiong.springboot.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-11-03
 * @Time:9:50
 * @Description 测试原生JDBC/MyBatis/JPA
 */
@RestController
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 获取所有角色列表
     *
     * @return
     */
    @GetMapping("/jdbc/roles")
    public List<Map<String, Object>> listRoles() {
        return roleService.listRoles();
    }

    /**
     * 通过角色id获取角色
     *
     * @param id 角色id
     * @return
     */
    @GetMapping("/jdbc/roles/{id}")
    public List<Map<String, Object>> selectRoleById(@PathVariable Integer id) {
        return roleService.selectRoleById(id);
    }


    /**
     * 添加数据
     *
     * @param role JSON数据
     * @return
     */
    @PostMapping("/jdbc/roles")
    public JSONObject insertRole(@RequestBody Role role) {
        return MessageUtil.getExecuteResult(roleService.insertRole(role));
    }

    /**
     * 修改数据
     *
     * @param role JSON数据
     * @return
     */
    @PutMapping("/jdbc/roles")
    public JSONObject updateRole(@RequestBody Role role) {
        return MessageUtil.getExecuteResult(roleService.updateRole(role));
    }

    /**
     * 删除数据
     *
     * @param id 角色id
     * @return
     */
    @DeleteMapping("/jdbc/roles/{id}")
    public JSONObject deleteRoleById(@PathVariable Integer id) {
        return MessageUtil.getExecuteResult(roleService.deleteRoleById(id));
    }

    /**
     * 判断数据库是否支持事务
     *
     * @return
     */
    @GetMapping("/jdbc/meta/transaction/supported")
    public boolean supportedTransaction() {
        return roleService.supportedTransaction();
    }

    /**
     * 通过角色名称查询角色
     *
     * @param roleName 角色名称
     * @return
     */
    @GetMapping("/mybatis/{roleName}")
    public Role selectByRoleName(@PathVariable String roleName) {
        return roleService.selectByRoleName(roleName);
    }

    /**
     * 测试spring-retry模块功能
     */
    @GetMapping("/retry/roles")
    public void retryOnException() {
        roleService.retryOnException();
    }
}
