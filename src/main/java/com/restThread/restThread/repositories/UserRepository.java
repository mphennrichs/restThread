package com.restThread.restThread.repositories;

import com.restThread.restThread.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
//    List<User> findAll();
//    User findById(String id);
}
