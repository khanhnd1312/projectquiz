package com.example.projectquiz.io.request.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private List<CourseQuestionRequest> courseQuestions = new ArrayList<>();
}
