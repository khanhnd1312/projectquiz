package com.example.projectquiz.repository;

import com.example.projectquiz.entity.UserAnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends CrudRepository<UserAnswerEntity, Integer> {
    UserAnswerEntity save(UserAnswerEntity userAnswerEntity);
}
