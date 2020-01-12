package com.example.projectquiz.service;

import com.example.projectquiz.model.Course;
import com.example.projectquiz.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public  CourseServiceImpl (CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAllCourse(){
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Integer id_course){
        return courseRepository.findById(id_course);
    }

    @Override
    public void save(Course course){
        courseRepository.save(course);
    }

    @Override
    public  void remove(Course course){
        courseRepository.delete(course);
    }
}
