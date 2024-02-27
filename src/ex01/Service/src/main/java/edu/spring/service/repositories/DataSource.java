package edu.spring.service.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public DataSource(String jdbcUrl, String userName, String password) {
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(userName);
        config.setPassword(password);
        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
