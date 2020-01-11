package com.example.projectquiz.service;

import com.example.projectquiz.entity.QA;

import java.util.List;
import java.util.Optional;

public interface QAService {

//        List<QA> findAllQAById(Integer idCourse);
        Optional<QA> findById(Integer idCourse);
        List<QA> getQaByIdcourse(Integer idCourse);
        void save(QA qa);
        void remove(QA qa);

}
