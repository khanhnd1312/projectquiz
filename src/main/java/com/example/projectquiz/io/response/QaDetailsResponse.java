package com.example.projectquiz.io.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QaDetailsResponse {
    private Long idCourseQuestion;
    private Long idCourse;
    private String nameQuestion;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
}
