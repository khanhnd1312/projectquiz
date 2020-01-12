package com.example.projectquiz.controller;

import com.example.projectquiz.dto.UserDto;
import com.example.projectquiz.model.User;
import com.example.projectquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser() {
        List<User> user = userService.findAllUser();
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer idUser) {
        UserDto user = userService.findById(idUser);

        if (user == null) {
            return new ResponseEntity<>(user,
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(
            @RequestBody User user,
            UriComponentsBuilder builder) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(
            @PathVariable("id") Integer idUser) {
        UserDto user = userService.findById(idUser);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        return null;
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Integer idUser,
            @RequestBody User user) {
//        Optional<User> currentUser = userService
//                .findById(idUser);
//
//        if (!currentUser.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        currentUser.get().setAccountUser(user.getAccountUser());
//        currentUser.get().setPasswordUser(user.getPasswordUser());
//
//        userService.save(currentUser.get());
//        return new ResponseEntity<>(currentUser.get(), HttpStatus.OK);

        return null;
    }

}
