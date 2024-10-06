package com.code.system.dao;

import com.code.system.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
        List<User> selectUsers();
        Optional<User> selectUserById(int id);
        int insertUser(User user);
        int deleteUser(int id);
        int updateUser(User user);
}
