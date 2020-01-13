package com.example.projectquiz.repository;

import com.example.projectquiz.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
    List<CourseEntity> findAll();
    CourseEntity findByIdCourse(Long idCourse);
    CourseEntity save(CourseEntity courseEntity);
}
