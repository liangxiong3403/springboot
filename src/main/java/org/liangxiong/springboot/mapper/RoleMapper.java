package org.liangxiong.springboot.mapper;

import org.apache.ibatis.annotations.*;
import org.liangxiong.springboot.entity.Role;

/**
 * @author liangxiong
 * @Description 测试MyBatis相关功能
 * @Date 2018-11-04
 * @Time 9:58
 */
@Mapper
public interface RoleMapper {

    /**
     * 通过角色名称查询角色
     *
     * @param roleName 角色名称
     * @return
     */
    ///@Select("SELECT id, role_name, is_deleted, description FROM t_role WHERE role_name = #{roleName}")
    ///@Results({@Result(column = "role_name", property = "roleName"), @Result(column = "is_deleted", property = "delete")})
    Role selectByRoleName(@Param("roleName") String roleName);
}
