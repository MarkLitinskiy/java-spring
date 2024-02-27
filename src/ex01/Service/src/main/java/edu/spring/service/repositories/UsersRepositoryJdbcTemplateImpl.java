package edu.spring.service.repositories;

import edu.spring.service.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{

    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    public UsersRepositoryJdbcTemplateImpl(String driverClass, String username, String url, String password) throws ClassNotFoundException {
        dataSource.setDriverClass((Class<Driver>)Class.forName(driverClass));
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
    }

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Override
    public Optional findByEmail(String email) {
        Long id = jdbcTemplate.queryForObject(
                "select id from users where email = ?",
                Long.class, email);
        return Optional.of(new User(id, email));
    }

    @Override
    public Optional findById(Long id) throws SQLException {
        String email = jdbcTemplate.queryForObject("select email from users where id = ?",
                String.class, id);
        return Optional.of(new User(id, email));
    }

    @Override
    public List findAll() throws SQLException {
        return null;
    }

}
