package com.example.projectquiz.repository;

import com.example.projectquiz.entity.UserAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends CrudRepository<UserAnswer, Integer> {
}
