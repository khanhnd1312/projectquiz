package com.example.projectquiz.controller;

import com.example.projectquiz.dto.UserDto;
import com.example.projectquiz.dto.UserSession;
import com.example.projectquiz.io.ErrorResponse;
import com.example.projectquiz.io.ResponseObject;
import com.example.projectquiz.io.SuccessResponse;
import com.example.projectquiz.io.request.user.LoginRequest;
import com.example.projectquiz.io.request.user.UserSignUpRequest;
import com.example.projectquiz.io.request.user.UserUpdateRequest;
import com.example.projectquiz.io.response.UserDetailsResponse;
import com.example.projectquiz.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> findAllUser() {
        List<UserDto> userDtos = userService.findAllUser();

        if (userDtos.isEmpty() || userDtos == null) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.NOT_FOUND.value(),
                            ErrorResponse.NO_RECORD_FOUND.getErrorMessage()),
                    HttpStatus.NOT_FOUND);
        } else {

            List<UserDetailsResponse> responses = new ArrayList<>();

            for (UserDto userDto : userDtos) {
                UserDetailsResponse res = new UserDetailsResponse();
                BeanUtils.copyProperties(userDto, res);

                responses.add(res);
            }

            return new ResponseEntity<>(responses, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserById(@PathVariable("id") Long idUser) {
        UserDto userDto = userService.findById(idUser);

        if (userDto == null) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.NOT_FOUND.value(),
                            ErrorResponse.NO_RECORD_FOUND.getErrorMessage()),
                    HttpStatus.NOT_FOUND);
        } else {

            UserDetailsResponse res = new UserDetailsResponse();
            BeanUtils.copyProperties(userDto, res);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserSignUpRequest request) {

        UserDto requestDto = new UserDto();
        BeanUtils.copyProperties(request, requestDto);

        UserDto createdUser = userService.createUser(requestDto);
        if (createdUser == null) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.BAD_REQUEST.value(),
                            ErrorResponse.CREATE_FAILED.getErrorMessage()),
                    HttpStatus.BAD_REQUEST);
        } else {
            UserDetailsResponse res = new UserDetailsResponse();
            BeanUtils.copyProperties(createdUser, res);

            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable("id") Long idUser,
            @RequestBody @Valid UserUpdateRequest request) {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(request, userDto);

        UserDto updatedUser = userService.updateUser(idUser, userDto);

        if (updatedUser == null) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.BAD_REQUEST.value(),
                            ErrorResponse.UPDATE_FAILED.getErrorMessage()),
                    HttpStatus.BAD_REQUEST);
        } else {
            UserDetailsResponse res = new UserDetailsResponse();
            BeanUtils.copyProperties(updatedUser, res);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long idUser) {
        boolean isUserDeleted = userService.deleteUser(idUser);

        if (!isUserDeleted) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            ErrorResponse.DELETE_FAILED.getErrorMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.OK.value(),
                            SuccessResponse.DELETE_SUCCESS.getSuccessMessage()),
                    HttpStatus.OK);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest req, HttpServletRequest request) {
        try{
            UserSession result = userService.login(req);

            // Result is token. Set session.
            request.getSession().setAttribute("USER_SESSION", result);

            return ResponseEntity.ok("LOGIN SUCCESS");
        } catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }


    }

}
