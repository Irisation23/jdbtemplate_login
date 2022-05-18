package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findByUserName(String name) {
        return jdbcTemplate.queryForObject(
                "select id,username,password,createdAt from JdbcUsers  where name = ?",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at")), name);
    }

    @Override
    public List<User> findByAll() {
        return jdbcTemplate.query(
                "select id,username,password, created_at from JdbcUsers",
                (resultSet, rowNum) ->
                        new User(resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getTimestamp("created_at")));
    }
}
