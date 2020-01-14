package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "tbl_user_course_answer")
public class UserAnswerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUserCourseAnswer;

    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "result")
    private String strResult;

    @Column(name = "total_correct")
    private Integer totalCorrect;

    public UserAnswerEntity() {

    }

}
