package com.example.projectquiz.controller;

import com.example.projectquiz.model.Course;
import com.example.projectquiz.model.QA;
import com.example.projectquiz.model.User;
import com.example.projectquiz.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class QAController {

    private QAService qaService;

    @Autowired
    public QAController(QAService qaService) {
        this.qaService = qaService;
    }


    @RequestMapping(value = "/qa/{idCourse}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QA>> getQaByIdCourse(@PathVariable Integer idCourse) {
        //System.out.println("idCourse : " + idCourse);
        List<QA> qa = qaService.getQaByIdcourse(idCourse);

        if (qa.isEmpty()) {
            return new ResponseEntity<>(qa,
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(qa, HttpStatus.OK);
    }

    @RequestMapping(value = "/createqa", method = RequestMethod.POST)
    public ResponseEntity<QA> createQA(
            @RequestBody QA qa,
            UriComponentsBuilder builder) {
        qaService.save(qa);
        return new ResponseEntity<>(qa, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/qa/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<QA> deleteQA(
            @PathVariable("id") Integer idCourseQuestion) {
        Optional<QA> qa = qaService.findById(idCourseQuestion);
        if (!qa.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        qaService.remove(qa.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/qa/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<QA> updateQA(
            @PathVariable("id") Integer idCourseQuestion,
            @RequestBody QA qa) {
        Optional<QA> currentQA = qaService.findById(idCourseQuestion);

        if (!currentQA.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentQA.get().setIdCourse(qa.getIdCourse());
        currentQA.get().setNameQuestion(qa.getNameQuestion());
        currentQA.get().setOptionA(qa.getOptionA());
        currentQA.get().setOptionB(qa.getOptionB());
        currentQA.get().setOptionC(qa.getOptionC());
        currentQA.get().setOptionD(qa.getOptionD());
        currentQA.get().setCorrectAnswer(qa.getCorrectAnswer());

        qaService.save(currentQA.get());
        return new ResponseEntity<>(currentQA.get(), HttpStatus.OK);
    }


}
