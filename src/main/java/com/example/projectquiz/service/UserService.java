package com.example.projectquiz.service;

import com.example.projectquiz.dto.UserDto;
import com.example.projectquiz.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();
    UserDto findById(Integer idUser);
    Integer getinfouserloyalty(Integer idUser);
    void save(User user);
    void remove(User user);
}
