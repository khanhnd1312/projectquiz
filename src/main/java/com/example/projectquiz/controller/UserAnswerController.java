package com.example.projectquiz.controller;

import com.example.projectquiz.dto.CourseDto;
import com.example.projectquiz.io.request.course.CourseRequest;
import com.example.projectquiz.service.answer.UserAnswerService;
import com.example.projectquiz.service.qa.QAService;
import org.springframework.security.core.Authentication;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserAnswerController {

    private UserAnswerService userAnswerService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private QAService qaService;

    @Autowired
    public UserAnswerController(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }


    @PostMapping(value = "/startexam/{idCourse}")
    public ResponseEntity<?> postExam(
            @RequestBody CourseRequest courseRequest,
            @PathVariable Long idCourse) {

        CourseDto courseDto = modelMapper.map(courseRequest, CourseDto.class);
        courseDto.setIdCourse(idCourse);

        Integer examResult = userAnswerService.examResult(courseDto);

        if (examResult == null) {
            return ResponseEntity.ok("Failed");
        } else {
            return ResponseEntity.ok(examResult);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getInfoOfUserLogin() {
        // Ví dụ lấy thông tin người thực hiện tác vụ createUser từ trong SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Đây là lấy ra userId vì mình set thế
        Long idUser = (long) auth.getPrincipal();
        System.out.println(idUser);
        // Để lấy ra các thông tin khác vd như userId thì yêu cầu phải lưu trong thông tin vào object
        // và object được lưu trong Credentials. Gọi hàm getCredentials() để lấy ra object rồi tiếp tục lấy ra các property khác
        // auth.getCredentials()

        return ResponseEntity.ok(((org.springframework.security.core.Authentication) auth).getCredentials());
    }
}
