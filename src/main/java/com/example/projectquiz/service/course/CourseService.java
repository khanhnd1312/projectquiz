package com.example.projectquiz.service.course;

import com.example.projectquiz.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> findAllCourse();
    CourseDto findById(Long idCourse);
    CourseDto createCourse(CourseDto courseDto);
    boolean deleteCourse(Long idCourse);
    CourseDto updateCourse(Long idCourse,CourseDto courseDto);

}
