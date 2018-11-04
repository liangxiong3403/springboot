package org.liangxiong.springboot.service.impl;

import org.liangxiong.springboot.entity.Role;
import org.liangxiong.springboot.mapper.RoleMapper;
import org.liangxiong.springboot.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @author liangxiong
 * @Date:2018-11-03
 * @Time:17:11
 * @Description
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RoleMapper roleMapper;

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Integer insertRole(Role role) {
        int status = 0;
        String sql = "INSERT INTO t_role(role_name, description) values (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role.getRoleName());
            statement.setString(2, role.getDescription());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL异常: ", e.getMessage());
        }
        return Integer.valueOf(status);
    }

    @Override
    public Integer updateRole(Role role) {
        int status = 0;
        String sql = "UPDATE t_role SET role_name = ?, description = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            status = jdbcTemplate.execute(sql, (PreparedStatementCallback<Integer>) ps -> {
                statement.setString(1, role.getRoleName());
                statement.setString(2, role.getDescription());
                statement.setInt(3, role.getId().intValue());
                return statement.executeUpdate();
            });
        } catch (SQLException e) {
            logger.error("SQL异常: {}", e.getMessage());
        }
        return Integer.valueOf(status);
    }

    @Override
    public Integer deleteRoleById(Integer id) {
        Integer status = Integer.valueOf(0);
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "DELETE FROM t_role WHERE id = ?";
        try {
            connection = dataSource.getConnection();
            // 关闭自动提交
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id.intValue());
            status = statement.executeUpdate();
            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            logger.error("SQL异常: ", e.getMessage());
        } finally {
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("statement关闭异常: {}", e.getMessage());
                }
            }
            if (null != connection) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    logger.error("connection关闭异常: {}", e.getMessage());
                }
            }
        }
        return Integer.valueOf(status);
    }

    @Override
    public List<Map<String, Object>> listRoles() {
        String sql = "SELECT id, role_name, description, is_deleted FROM t_role";
        return executeQuery(sql, null);
    }

    @Override
    public List<Map<String, Object>> selectRoleById(Integer id) {
        String sql = "SELECT id, role_name, description, is_deleted FROM t_role WHERE id = ?";
        return executeQuery(sql, id);
    }

    @Override
    public boolean supportedTransaction() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            return databaseMetaData.supportsTransactions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Role selectByRoleName(String roleName) {
        return roleMapper.selectByRoleName(roleName);
    }

    private List<Map<String, Object>> executeQuery(String sql, Integer id) {
        List<Map<String, Object>> result = new LinkedList<>();
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if (id != null) {
                // 设置参数
                statement.setInt(1, id.intValue());
            }
            // 执行SQL
            resultSet = statement.executeQuery();
            // 获取元数据
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            // 获取字段个数
            int columnCount = resultSetMetaData.getColumnCount();
            // 获取所有数据库字段名称集合
            List<String> columnNames = new ArrayList<>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                columnNames.add(columnName);
            }
            // 遍历结果集
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>(8);
                for (String columnName : columnNames) {
                    Object columnData = resultSet.getObject(columnName);
                    data.put(columnName, columnData);
                }
                result.add(data);
            }
        } catch (SQLException e) {
            logger.error("SQL异常: {}", e.getMessage());
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("resultSet关闭异常: {}", e.getMessage());
                }
            }
        }
        return result;
    }
}
