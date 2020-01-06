package com.example.projectquiz.controller;

import com.example.projectquiz.model.Course;
import com.example.projectquiz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/course/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer idCourse) {
        Optional<Course> course = courseService.findById(idCourse);

        if (!course.isPresent()) {
            return new ResponseEntity<>(course.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(course.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createcourse", method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(
            @RequestBody Course course,
            UriComponentsBuilder builder) {
        courseService.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/course/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse(
            @PathVariable("id") Integer idCourse) {
        Optional<Course> course = courseService.findById(idCourse);
        if (!course.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseService.remove(course.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
