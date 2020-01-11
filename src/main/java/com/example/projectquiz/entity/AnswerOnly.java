package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class AnswerOnly implements Serializable {

    private Integer idCourseQuestion;
    private Integer idAnswer;

    public AnswerOnly(){

    }
}
