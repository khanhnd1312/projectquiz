package com.example.projectquiz.controller;

import com.example.projectquiz.model.AnswerOnly;
import com.example.projectquiz.model.QA;
import com.example.projectquiz.service.QAService;
import com.example.projectquiz.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UserAnswerController {

    private UserAnswerService userAnswerService;

    @Autowired
    private QAService qaService;

    @Autowired
    public UserAnswerController(UserAnswerService userAnswerService) {this.userAnswerService = userAnswerService;}


    @RequestMapping (value = "/doexam/{idCourse}",method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> postExam(
            @RequestBody List<AnswerOnly> ao,
            UriComponentsBuilder builder,
            @PathVariable Integer idCourse) {

        List<QA> getlistqa = qaService.getQaByIdcourse(idCourse);

        int kq = 0;
        for (int i = 0 ; i < getlistqa.size() ; i++){
            if(ao.get(i).getIdCourseQuestion() == getlistqa.get(i).getIdCourseQuestion()){
                if(ao.get(i).getIdAnswer() == getlistqa.get(i).getCorrectAnswer()){
                    kq += 1;
                }
            }
        }

        return new ResponseEntity(kq,HttpStatus.CREATED);
    }
}
