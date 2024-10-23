package com.code.system.user.dao;

import com.code.system.user.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder().id(rs.getInt("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .phoneNumber(rs.getString("phone_number"))
                .address(rs.getString("address"))
                .build();
    }
}
