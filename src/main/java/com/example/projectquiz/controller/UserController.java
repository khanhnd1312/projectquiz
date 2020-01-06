package com.example.projectquiz.controller;

import com.example.projectquiz.model.User;
import com.example.projectquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser(){
        List<User> user = userService.findAllUser();
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer idUser) {
        Optional<User> user = userService.findById(idUser);

        if (!user.isPresent()) {
            return new ResponseEntity<>(user.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
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
    public ResponseEntity<User> deleteUser(
            @PathVariable("id") Integer idUser) {
        Optional<User> user = userService.findById(idUser);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(user.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
