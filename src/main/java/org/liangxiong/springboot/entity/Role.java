package org.liangxiong.springboot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:20:41
 * @Description 角色实体,Access指定注入类型
 */
@Entity
@Getter
@Setter
@Access(AccessType.FIELD)
@NoArgsConstructor
@Table(name = "t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 2689434860278764430L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称
     */
    @Size(min = 1, max = 16)
    private String roleName;

    /**
     * 角色描述
     */
    @Size(min = 1, max = 16)
    private String description;

    /**
     * 表示是否被删除
     */
    @Column(name = "is_deleted")
    private boolean delete;

    /**
     * 一个角色可以对应多个用户
     */
    @JSONField(serialize = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "role")
    private Set<User> users = new HashSet<>(8);

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", delete=" + delete +
                '}';
    }
}
