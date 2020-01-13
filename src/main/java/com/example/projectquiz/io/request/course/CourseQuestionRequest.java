package com.example.projectquiz.io.request.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseQuestionRequest {
    private Long idCourseQuestion;
    private Long idCourseAnswer;
}
