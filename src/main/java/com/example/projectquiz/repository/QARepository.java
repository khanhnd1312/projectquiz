package com.example.projectquiz.repository;

import com.example.projectquiz.entity.QaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QARepository extends CrudRepository<QaEntity, Integer> {

    List<QaEntity> findAllByIdCourse(Long idCourse);

    QaEntity save(QaEntity qaEntity);

    QaEntity findByIdCourseQuestion(Long idCourseQuestion);

}
