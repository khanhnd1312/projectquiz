package com.example.projectquiz.model;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Getter
@Setter

public class AnswerOnly implements Serializable {

    private Integer idCourseQuestion;
    private Integer idAnswer;

    public AnswerOnly(){

    }
}
