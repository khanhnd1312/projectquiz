package com.example.projectquiz.controller;

import com.example.projectquiz.dto.CourseDto;
import com.example.projectquiz.io.ErrorResponse;
import com.example.projectquiz.io.ResponseObject;
import com.example.projectquiz.io.SuccessResponse;
import com.example.projectquiz.service.course.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    @GetMapping()
    public ResponseEntity<?> findAllCourse(){

        List<CourseDto> courseDtos = courseService.findAllCourse();

        if(courseDtos.isEmpty() || courseDtos==null ){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.NOT_FOUND.value(),
                            ErrorResponse.NO_RECORD_FOUND.getErrorMessage()),
                    HttpStatus.NOT_FOUND);
        }else{
            List<CourseDto> responses = new ArrayList<>();

            for (CourseDto courseDto : courseDtos){
                CourseDto cou = new CourseDto();
                BeanUtils.copyProperties(courseDto,cou);

                responses.add(cou);
            }
            return new ResponseEntity<>(responses, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long idCourse) {

        CourseDto courseDto = courseService.findById(idCourse);

        if (courseDto==null) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.NOT_FOUND.value(),
                            ErrorResponse.NO_RECORD_FOUND.getErrorMessage()),
                    HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(courseDto ,HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto requestDto = new CourseDto();
        BeanUtils.copyProperties(courseDto,requestDto);

        CourseDto createdCourse = courseService.createCourse(requestDto);

        if (createdCourse==null){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.BAD_REQUEST.value(),
                            ErrorResponse.CREATE_FAILED.getErrorMessage()),
                    HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        }

    }
//
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long idCourse) {
        boolean isCourseDeleted = courseService.deleteCourse(idCourse);

        if (!isCourseDeleted) {
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            ErrorResponse.DELETE_FAILED.getErrorMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.OK.value(),
                            SuccessResponse.DELETE_SUCCESS.getSuccessMessage()),
                    HttpStatus.OK);
        }
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> updateCourse(
            @PathVariable("id") Long idCourse,
            @RequestBody CourseDto courseDto) {
        CourseDto cou = new CourseDto();
        BeanUtils.copyProperties(courseDto,cou);

        CourseDto updatecourse = courseService.updateCourse(idCourse,cou);

        if (updatecourse==null){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.BAD_REQUEST.value(),
                            ErrorResponse.UPDATE_FAILED.getErrorMessage()),
                    HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(updatecourse, HttpStatus.OK);
        }

    }



}
