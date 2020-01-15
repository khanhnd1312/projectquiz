package com.example.projectquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QaDto implements Serializable {
    private static final long serialVersionUID = 4065644351070573219L;

    private Long idCourseQuestion;
    private Long idCourse;
    private String nameQuestion;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Long correctAnswer;

}
