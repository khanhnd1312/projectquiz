package com.example.projectquiz.controller;

import com.example.projectquiz.dto.QaDto;
import com.example.projectquiz.entity.QaEntity;
import com.example.projectquiz.io.ErrorResponse;
import com.example.projectquiz.io.ResponseObject;
import com.example.projectquiz.io.SuccessResponse;
import com.example.projectquiz.io.request.UserUpdateRequest;
import com.example.projectquiz.io.response.QaDetailsResponse;
import com.example.projectquiz.service.qa.QAService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/qas")
public class QAController {

    private QAService qaService;

    @Autowired
    public QAController(QAService qaService) {
        this.qaService = qaService;
    }


    @RequestMapping(value = "{idCourse}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getQaByIdCourse(@PathVariable Long idCourse) {
        List<QaDto> qaDtos = qaService.findByIdCourse(idCourse);

        if (qaDtos==null){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.NOT_FOUND.value(),
                            ErrorResponse.NO_RECORD_FOUND.getErrorMessage()),
                    HttpStatus.NOT_FOUND);
        }else{
            List<QaDetailsResponse> qares = new ArrayList<>();
            for (QaDto qaDto : qaDtos){
                QaDetailsResponse qar = new QaDetailsResponse();
                BeanUtils.copyProperties(qaDto,qar);

                qares.add(qar);
            }
            return new ResponseEntity<>(qares,HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<?> createQA(@RequestBody QaEntity qa) {
        QaDto qaDto = new QaDto();
        BeanUtils.copyProperties(qa,qaDto);

        QaDto createdQa = qaService.createQa(qaDto);

        if (createdQa==null){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.BAD_REQUEST.value(),
                            ErrorResponse.CREATE_FAILED.getErrorMessage()),
                    HttpStatus.BAD_REQUEST);
        }else{

            return new ResponseEntity<>(createdQa,HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteQA(
            @PathVariable("id") Long idCourseQuestion) {
        boolean isQaDeleted = qaService.deleteQa(idCourseQuestion);

        if(!isQaDeleted){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            ErrorResponse.DELETE_FAILED.getErrorMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.OK.value(),
                            SuccessResponse.DELETE_SUCCESS.getSuccessMessage()),
                    HttpStatus.OK);
        }
    }
//
    @PutMapping(value = "{id}")
    public ResponseEntity<?> updateQa (
            @PathVariable("id") Long idCourseQuestion,
            @RequestBody QaDto qaDto){

        QaDto qaDtoreceive = new QaDto();
        BeanUtils.copyProperties(qaDto,qaDtoreceive);

        QaDto updatedQa = qaService.updateQa(idCourseQuestion,qaDtoreceive);

        if (updatedQa==null){
            return new ResponseEntity<>(
                    new ResponseObject(
                            HttpStatus.BAD_REQUEST.value(),
                            ErrorResponse.UPDATE_FAILED.getErrorMessage()),
                    HttpStatus.BAD_REQUEST);
        }else{
            QaDto newQa = new QaDto();
            BeanUtils.copyProperties(updatedQa,newQa);

            return new ResponseEntity<>(newQa, HttpStatus.OK);
        }
    }



}
