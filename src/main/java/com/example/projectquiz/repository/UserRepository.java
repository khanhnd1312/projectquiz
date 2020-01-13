package com.example.projectquiz.repository;

import com.example.projectquiz.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findByIdUser(Long id);
    UserEntity findByAccountUser(String accountUser);
    UserEntity save(UserEntity userEntity);
    boolean existsByAccountUser(String accountUser);
}
