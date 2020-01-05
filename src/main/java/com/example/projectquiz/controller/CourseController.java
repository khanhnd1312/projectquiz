package com.example.projectquiz.controller;

import com.example.projectquiz.model.Course;
import com.example.projectquiz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @RequestMapping(value = "/course" , method = RequestMethod.GET)
    public ResponseEntity<List<Course>> findAllCourse(){
        List<Course> course = courseService.findAllCourse();
        if(course.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

}
