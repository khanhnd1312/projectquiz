package com.example.projectquiz.service.user;

import com.example.projectquiz.dto.UserDto;
import com.example.projectquiz.dto.UserSession;
import com.example.projectquiz.io.request.user.LoginRequest;

import java.util.List;

public interface UserService {
    UserSession login(LoginRequest req);

    List<UserDto> findAllUser();

    UserDto findById(Long idUser);

    UserDto createUser(UserDto requestDto);

    UserDto updateUser(Long id, UserDto requestDto);

    boolean deleteUser(Long id);
}
