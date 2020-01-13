package com.example.projectquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AnswerDto implements Serializable {
    private static final long serialVersionUID = -6803016154372537127L;

    private Long idUserCourseAnswer;
    private Long idCourse;
    private String strResult;
    private Integer totalCorrect;
}
