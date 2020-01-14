package com.example.projectquiz.service.answer;

import com.example.projectquiz.dto.CourseDto;
import com.example.projectquiz.dto.CourseQuestionDto;
import com.example.projectquiz.entity.QaEntity;
import com.example.projectquiz.entity.UserAnswerEntity;
import com.example.projectquiz.repository.QARepository;
import com.example.projectquiz.repository.UserAnswerRepository;
import com.example.projectquiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    private UserRepository userRepository;
    private UserAnswerRepository userAnswerRepository;

    @Autowired
    private QARepository qaRepository;

    @Autowired
    public UserAnswerServiceImpl(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    @Override
    public Integer examResult(CourseDto courseDto) {
        //Question list
        List<QaEntity> getlistqa = qaRepository.findAllByIdCourse(courseDto.getIdCourse());
        List<CourseQuestionDto> ao = courseDto.getCourseQuestions();
        Integer result = 0;

        for (int i = 0; i < getlistqa.size(); i++) {
            if (courseDto.getCourseQuestions().get(i).getIdCourseQuestion() == getlistqa.get(i).getIdCourseQuestion()) {
                if (ao.get(i).getIdCourseAnswer() == getlistqa.get(i).getCorrectAnswer()) {
                    result += 1;
                }
            }
        }

        Long idUser = getUserId();

        if (saveResult(courseDto.getIdCourse(), ao, result , idUser)) {
            return result;
        } else {
            return null;
        }
    }

    private boolean saveResult(Long idCourse, List<CourseQuestionDto> ao, Integer result , Long idUser) {
        try {
            UserAnswerEntity userAnswerEntity = new UserAnswerEntity();
            userAnswerEntity.setIdUser(idUser);
            userAnswerEntity.setIdCourse(idCourse);
            userAnswerEntity.setStrResult(ao.toString());
            userAnswerEntity.setTotalCorrect(result);

            UserAnswerEntity savedAnswer = userAnswerRepository.save(userAnswerEntity);
            //savedAnswer.getStrResult();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private Long getUserId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Đây là lấy ra userId vì mình set thế
        long idUser = (long) auth.getPrincipal();
        return idUser;

    }


}
