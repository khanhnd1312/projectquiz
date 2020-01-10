package com.example.projectquiz.service;

import com.example.projectquiz.model.UserAnswer;
import com.example.projectquiz.repository.UserAnswerRepository;
import com.example.projectquiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    private UserAnswerRepository userAnswerRepository;

    @Autowired
    public UserAnswerServiceImpl(UserAnswerRepository userAnswerRepository) {this.userAnswerRepository = userAnswerRepository;}

    @Override
    public void save(UserAnswer userAnswer) {userAnswerRepository.save(userAnswer);}
}
