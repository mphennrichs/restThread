package com.restThread.restThread.services;

import com.restThread.restThread.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
