package org.liangxiong.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author liangxiong
 * @description 加密数据库密码字段
 * @date 2019-01-02
 * @time 20:09
 */
@Configuration
public class DatasourcePasswordConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DatasourcePasswordConfiguration.class);

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String username = "root";

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.druid.initial-size}")
    public Integer initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private Integer minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private Integer maxActive;

    @Value("${spring.datasource.druid.max-wait}")
    private Integer maxWait;

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-on-borrow}")
    private Boolean testOnBorrow;

    @Value("${spring.datasource.druid.pool-prepared-statements}")
    private Boolean poolPreparedStatements;

    @Value("${spring.datasource.druid.filters}")
    private String filters;

    @Value("${spring.datasource.druid.connect-properties}")
    private String connectionProperties;

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setConnectionProperties(connectionProperties);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter: {}", e.getMessage());
        }
        return datasource;
    }

}
