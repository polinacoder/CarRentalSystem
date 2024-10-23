package com.code.system.user.dao;

import com.code.system.user.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectUsers() {
        var sql = """
                SELECT id, first_name, last_name, phone_number, address
                FROM users
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public Optional<User> selectUserById(int id) {
        var sql = """
                SELECT id, first_name, last_name, phone_number, address
                FROM users
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new UserMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int insertUser(User user) {
        var sql = """
                INSERT INTO users(first_name, last_name, phone_number, address)
                VALUES (?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                user.firstName(), user.lastName(), user.phoneNumber(), user.address()
        );
    }

    @Override
    public int updateUser(User user) {
        var sql = """
                UPDATE user
                SET first_name = ?, last_name = ?, phone_number = ?, address = ?
                WHERE id = ?;
                 """;
        return jdbcTemplate.update(
                sql,
                user.firstName(), user.lastName(), user.phoneNumber(), user.address(), user.id()
        );
    }

    @Override
    public int deleteUser(int id) {
        var sql = """
                DELETE FROM users WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

}
