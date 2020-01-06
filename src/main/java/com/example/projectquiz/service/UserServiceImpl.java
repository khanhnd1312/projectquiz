package com.example.projectquiz.service;

import com.example.projectquiz.model.User;
import com.example.projectquiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public  UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer idUser){
        return userRepository.findById(idUser);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public  void remove(User user){
        userRepository.delete(user);
    }

}
