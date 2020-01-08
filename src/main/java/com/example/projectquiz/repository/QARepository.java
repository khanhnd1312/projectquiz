package com.example.projectquiz.repository;

import com.example.projectquiz.model.QA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QARepository extends CrudRepository <QA, Integer> {
}
