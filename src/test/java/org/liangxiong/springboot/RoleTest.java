package org.liangxiong.springboot;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.liangxiong.springboot.entity.Role;
import org.liangxiong.springboot.mapper.RoleMapper;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author liangxiong
 * @Date:2018-11-04
 * @Time:20:02
 * @Description 测试MyBatis原生编程方式获取数据
 */
public class RoleTest {

    @Test
    public void testSelectRoleByName() {
        String resourcePath = "mybatis/mybatis-config.xml";
        SqlSession session = null;
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(resourcePath);
            EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
            Reader reader = encodedResource.getReader();
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(reader, "development");
            session = sqlSessionFactory.openSession();
            RoleMapper mapper = session.getMapper(RoleMapper.class);
            Role role = mapper.selectByRoleName("test");
            Assert.assertEquals("TEST", role.getRoleName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }
}
