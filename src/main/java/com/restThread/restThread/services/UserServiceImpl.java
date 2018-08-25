package com.restThread.restThread.services;

import com.google.common.collect.ImmutableList;
import com.restThread.restThread.domain.User;
import com.restThread.restThread.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = new ArrayList<>();

        userRepository.findAll().forEach(allUsers::add);

        return allUsers;
    }

    @Override
    public User getUser(Long id) {

        return  userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        try {
            userRepository.save(user);
        }catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
