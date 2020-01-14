package com.example.projectquiz.service.qa;

import com.example.projectquiz.dto.QaDto;

import java.util.List;

public interface QAService {

    List<QaDto> findByIdCourse(Long idCourse);

    QaDto createQa(QaDto qaDto);

    boolean deleteQa(Long idCourseQuestion);

    QaDto updateQa(Long idCourseQuestion, QaDto qaDtoreceive);


}
