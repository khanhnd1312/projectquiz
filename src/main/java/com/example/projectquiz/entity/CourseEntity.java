package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Getter
@Setter
@Entity(name="tbl_course")
//@Table(name = "tbl_course")
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCourse;

    @Column(name = "name_course")
    private String nameCourse;

    @Column(name = "quantity_question")
    private Integer quantityQuestion;

    @Column(name = "time")
    private Time time;

    public CourseEntity() {
    }

//    Get and Set
}
