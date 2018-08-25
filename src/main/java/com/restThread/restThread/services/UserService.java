package com.restThread.restThread.services;

import com.restThread.restThread.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    User addUser(User user);

    User updateUser(User user);
}
