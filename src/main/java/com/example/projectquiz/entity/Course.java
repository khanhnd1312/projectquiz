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
@Entity(name="tbl_course")
//@Table(name = "tbl_course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCourse;

    private String nameCourse;
    private Integer quantityQuestion;
    private Time time;

    public Course() {
    }

//    Get and Set
}
