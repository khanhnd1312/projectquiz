package com.example.projectquiz.service;

import com.example.projectquiz.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUser();
    Optional<User> findById(Integer idUser);
    void save(User user);
    void remove(User user);
}
