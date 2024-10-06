package com.code.system.dao;

import com.code.system.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("phone_number"),
                rs.getString("address"));
    }
}
