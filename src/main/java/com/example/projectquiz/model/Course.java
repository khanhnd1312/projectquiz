package com.example.projectquiz.model;

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
    private Time leftTime;

    public Course() {
    }
//    Get and Set
}

//public class Course {
//    private int idCourse;
//    private String nameCourse;
//    private int quantityQuestion;
//    private Time leftTime;
//
//    public Course(){
//
//    }
//
//    public int getId(){
//        return idCourse;
//    }
//    public int setId(int idCourse){
//        this.idCourse = idCourse;
//    }
//    public String getNameCourse(){
//        return nameCourse;
//    }
//    public String setNameCourse(String nameCourse){
//        this.nameCourse = nameCourse;
//    }
//    public int getQuantityQuestion(){
//        return quantityQuestion;
//    }
//    public int setQuantityQuestion(int quantityQuestion){
//        this.quantityQuestion = quantityQuestion;
//    }
//    public Time getLeftTime(){
//        return leftTime;
//    }
//    public Time setLeftTime(Time leftTime){
//        this.leftTime = leftTime;
//    }





