package org.liangxiong.springboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.liangxiong.springboot.listener.RoleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author liangxiong
 * Date:2018-10-08
 * Time:20:32
 * @Description 用户实体类, Access指定注入类型;EntityListeners行为化监听
 */
@Entity
@Getter
@Setter
@EntityListeners(RoleListener.class)
@Access(AccessType.FIELD)
@NoArgsConstructor
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1220720751875327420L;

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    /**
     * 主键:用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Size(min = 1, max = 8)
    private String username;

    /**
     * 年龄
     */
    @NotNull
    private Integer age;

    /**
     * 性别
     */
    @Size(min = 1, max = 6)
    private String sex;

    /**
     * 关系：多个用户对应于一个角色
     */
    @JoinColumn(name = "role_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, optional = false)
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", role=" + role +
                '}';
    }
}

