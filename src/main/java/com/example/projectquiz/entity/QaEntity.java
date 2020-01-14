package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "tbl_course_question")
public class QaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCourseQuestion;

    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "name_question")
    private String nameQuestion;

    @Column(name = "optiona")
    private String optionA;

    @Column(name = "optionb")
    private String optionB;

    @Column(name = "optionc")
    private String optionC;

    @Column(name = "optiond")
    private String optionD;

    @Column(name = "correct_answer")
    private Long correctAnswer;

    public QaEntity() {
    }
}
