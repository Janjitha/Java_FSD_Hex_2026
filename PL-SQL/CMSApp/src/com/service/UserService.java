package com.service;

import com.model.User;
import com.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User authenticateUser(String username, String password) throws SQLException {
       return userRepository.authenticateUser(username,password);
    }
}
