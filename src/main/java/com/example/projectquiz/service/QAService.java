package com.example.projectquiz.service;

import com.example.projectquiz.model.QA;

import java.util.List;
import java.util.Optional;

public interface QAService {

//        List<QA> findAllQAById(Integer idCourse);
//        Optional<QA> findQAById(Integer idCourseQuestion);
        void save(QA qa);
        void remove(QA qa);

}
