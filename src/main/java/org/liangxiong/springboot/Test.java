package org.liangxiong.springboot;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.liangxiong.springboot.entity.Role;
import org.liangxiong.springboot.mapper.RoleMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liangxiong
 * @Description
 * @Date 2018-11-04
 * @Time 15:44
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            RoleMapper mapper = session.getMapper(RoleMapper.class);
            Role role = mapper.selectByRoleName("test");
            System.out.println("role: " + role);
        } finally {
            session.close();
        }
    }
}
