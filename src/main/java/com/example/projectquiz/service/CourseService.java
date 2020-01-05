package com.example.projectquiz.service;

import com.example.projectquiz.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAllCourse();
    Optional<Course> findById(Integer idCourse);
    void save(Course course);
    void remove(Course course);
}
