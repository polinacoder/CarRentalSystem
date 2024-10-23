package com.code.system.user.service;

import com.code.system.user.dao.UserDao;
import com.code.system.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(){
        return userDao.selectUsers();
    }

    public User getUser(int id) {
        return userDao.selectUserById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void addUser(User user) {
        int result = userDao.insertUser(user);
        if (result != 1) {
            throw new IllegalStateException();
        }
    }

    public void updateUser(User user) {
        int result = userDao.updateUser(user);
        if (result != 1) {
            throw new IllegalStateException();
        }
    }

    public void deleteUser(Integer id) {
        Optional<User> users = userDao.selectUserById(id);
        users.ifPresentOrElse(user -> {
            int result = userDao.deleteUser(id);
            if (result != 1) {
                throw new IllegalStateException();
            }
        }, () -> {
            throw new NoSuchElementException();
        });
    }
}
