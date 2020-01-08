package com.example.projectquiz.controller;

import com.example.projectquiz.model.QA;
import com.example.projectquiz.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class QAController {

    private QAService qaService;

    @Autowired
    public QAController(QAService qaService) {
        this.qaService = qaService;
    }

    @RequestMapping(value = "/createqa", method = RequestMethod.POST)
    public ResponseEntity<QA> createQA(
            @RequestBody QA qa,
            UriComponentsBuilder builder) {
        System.out.println("Aop :" + qa.getAoption());
        System.out.println("Bop :" + qa.getBoption());
        System.out.println("Cop :" + qa.getCoption());
        System.out.println("Dop :" + qa.getDoption());
        qaService.save(qa);
        return new ResponseEntity<>(qa, HttpStatus.CREATED);
    }


}
