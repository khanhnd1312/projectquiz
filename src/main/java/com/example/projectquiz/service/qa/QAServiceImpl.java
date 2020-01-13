package com.example.projectquiz.service.qa;


import com.example.projectquiz.dto.QaDto;
import com.example.projectquiz.entity.QaEntity;
import com.example.projectquiz.repository.QARepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QAServiceImpl implements QAService {
    private QARepository qaRepository;

    @Autowired
    public QAServiceImpl (QARepository qaRepository) {this.qaRepository = qaRepository;}

    @Override
    public List<QaDto> findByIdCourse(Long idCourse){
        try {
            List<QaEntity> qaEntities =  qaRepository.findAllByIdCourse(idCourse);
            if (qaEntities==null){
                return null;
            }else{

                List<QaDto> qaDtos = new ArrayList<>();

                for (QaEntity qaEntity : qaEntities){
                    QaDto qaDto = new QaDto();
                    BeanUtils.copyProperties(qaEntity,qaDto);

                    qaDtos.add(qaDto);
                }

                return qaDtos;
            }

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public QaDto createQa(QaDto qaDto){
        QaEntity qaEntity = new QaEntity();
        BeanUtils.copyProperties(qaDto,qaEntity);

        QaDto createdQa = new QaDto();
        BeanUtils.copyProperties(qaRepository.save(qaEntity),createdQa);

        return createdQa;

    }

    @Override
    public boolean deleteQa(Long idCourseQuestion){
        try {
            QaEntity qaEntity = qaRepository.findByIdCourseQuestion(idCourseQuestion);

            if (qaEntity==null){
                return false;
            }else {
                qaRepository.delete(qaEntity);
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public QaDto updateQa(Long idCourseQuestion , QaDto qaDtoreceive){

        QaEntity qaEntity = qaRepository.findByIdCourseQuestion(idCourseQuestion);
        if (qaEntity==null){
            return null;
        }else{
            QaEntity updateQaEntity = new QaEntity();
            BeanUtils.copyProperties(qaDtoreceive,updateQaEntity);

            updateQaEntity.setIdCourseQuestion(idCourseQuestion);

            QaDto updatedQa = new QaDto();
            BeanUtils.copyProperties(qaRepository.save(updateQaEntity),updatedQa);

            return updatedQa;
        }
    }



}
