package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity(name="tbl_course_question")
public class QA implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCourseQuestion;

    private Integer idCourse;
    private String nameQuestion;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Integer correctAnswer;

    public QA() {
    }
}
