package org.liangxiong.springboot.service;

import org.liangxiong.springboot.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author liangxiong
 * @Date:2018-11-03
 * @Time:17:09
 * @Description
 */
public interface IRoleService {

    /**
     * 添加数据
     *
     * @param role
     * @return
     */
    Integer insertRole(Role role);

    /**
     * 修改数据
     *
     * @param role
     * @return
     */
    Integer updateRole(Role role);

    /**
     * 修改数据
     *
     * @param id
     * @return
     */
    Integer deleteRoleById(Integer id);

    /**
     * 查询所有角色
     *
     * @return
     */
    List<Map<String, Object>> listRoles();

    /**
     * 通过id查询角色
     *
     * @param id
     * @return
     */
    List<Map<String, Object>> selectRoleById(Integer id);

    /**
     * 查看数据库是否支持事务
     *
     * @return
     */
    boolean supportedTransaction();

    /**
     * 通过角色名称查询角色
     *
     * @param roleName 角色名称
     * @return
     */
    Role selectByRoleName(String roleName);

    /**
     * 测试spring-retry模块功能
     */
    void retryOnException();
}
