package com.example.projectquiz.controller;

import com.example.projectquiz.dto.CourseDto;
import com.example.projectquiz.entity.QaEntity;
import com.example.projectquiz.io.request.course.CourseRequest;
import com.example.projectquiz.service.qa.QAService;
import com.example.projectquiz.service.answer.UserAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAnswerController {

    private UserAnswerService userAnswerService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private QAService qaService;

    @Autowired
    public UserAnswerController(UserAnswerService userAnswerService) {this.userAnswerService = userAnswerService;}


    @PostMapping (value = "/doexam/{idCourse}")
    public ResponseEntity<?> postExam(
            @RequestBody CourseRequest courseRequest,
            @PathVariable Long idCourse) {

        CourseDto courseDto = modelMapper.map(courseRequest, CourseDto.class);
        courseDto.setIdCourse(idCourse);

        userAnswerService.examResult(courseDto);

        return null;
    }
}
