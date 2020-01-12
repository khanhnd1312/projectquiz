package com.example.projectquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@Getter
@Setter
public class CourseDto implements Serializable {

    private static final long serialVersionUID = 4694005920976694920L;
    private Long idCourse;
    private String nameCourse;
    private Integer quantityQuestion;
    private Time time;
}
