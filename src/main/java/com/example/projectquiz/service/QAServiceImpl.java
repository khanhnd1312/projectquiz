package com.example.projectquiz.service;


import com.example.projectquiz.entity.QA;
import com.example.projectquiz.repository.QARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QAServiceImpl implements QAService {
    private QARepository qaRepository;

    @Autowired
    public QAServiceImpl (QARepository qaRepository) {this.qaRepository = qaRepository;}

//    @Override
//    public List<QA> findAllQAByID(Integer idCourse){
//        return (List<QA>) qaRepository.findAll(idCourse);
//    }
//
    @Override
    public List<QA> getQaByIdcourse(Integer idCourse) {return qaRepository.findByIdCourse(idCourse);}

    @Override
    public Optional<QA> findById(Integer idCourse){
    return qaRepository.findById(idCourse);
}

    @Override
    public void save(QA qa){
        qaRepository.save(qa);
    }

    @Override
    public  void remove(QA qa){
        qaRepository.delete(qa);
    }
}
