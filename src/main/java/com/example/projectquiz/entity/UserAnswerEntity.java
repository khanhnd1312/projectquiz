package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

@Getter
@Setter
@Entity(name="tbl_user_course_answer")
public class UserAnswerEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUserCourseAnswer;

    private Integer idCourse;
    private Integer idUser;
    private String  strResult;
    private Integer totalCorrect;

    public UserAnswerEntity(){

    }

}
