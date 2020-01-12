package com.example.projectquiz.service.qa;

import com.example.projectquiz.dto.QaDto;
import com.example.projectquiz.entity.QaEntity;

import java.util.List;
import java.util.Optional;

public interface QAService {

        List<QaDto> findByIdCourse(Long idCourse);
        QaDto createQa(QaDto qaDto);
        boolean deleteQa(Long idCourseQuestion);
        QaDto updateQa(Long idCourseQuestion , QaDto qaDtoreceive);


}
