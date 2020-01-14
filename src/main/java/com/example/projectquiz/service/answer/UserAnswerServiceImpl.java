package com.example.projectquiz.service.answer;

import com.example.projectquiz.dto.CourseDto;
import com.example.projectquiz.dto.CourseQuestionDto;
import com.example.projectquiz.entity.QaEntity;
import com.example.projectquiz.entity.UserAnswerEntity;
import com.example.projectquiz.repository.QARepository;
import com.example.projectquiz.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

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

        if (saveResult(courseDto.getIdCourse(), ao, result)) {
            return result;
        } else {
            return null;
        }
    }

    private boolean saveResult(Long idCourse, List<CourseQuestionDto> ao, Integer result) {
        try {
            UserAnswerEntity userAnswerEntity = new UserAnswerEntity();
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


}
