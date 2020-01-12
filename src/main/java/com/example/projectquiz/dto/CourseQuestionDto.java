package com.example.projectquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class CourseQuestionDto implements Serializable {

    private static final long serialVersionUID = -8187448856876022086L;
    private Long idCourseQuestion;
    private Long idCourseAnswer;

}
