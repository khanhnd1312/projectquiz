package com.example.projectquiz.service.user;

import com.example.projectquiz.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUser();
    UserDto findById(Long idUser);
    UserDto createUser(UserDto requestDto);
    UserDto updateUser(Long id, UserDto requestDto);
    boolean deleteUser(Long id);
}
