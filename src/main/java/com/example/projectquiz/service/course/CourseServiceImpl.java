package com.example.projectquiz.service.course;

import com.example.projectquiz.dto.CourseDto;
import com.example.projectquiz.entity.CourseEntity;
import com.example.projectquiz.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public  CourseServiceImpl (CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> findAllCourse(){
       try {
           List<CourseEntity> courseEntities = courseRepository.findAll();
           List<CourseDto> courseDtos = new ArrayList<>();

           for (CourseEntity courseEntity : courseEntities){
               CourseDto courseDto = new CourseDto();
               BeanUtils.copyProperties(courseEntity,courseDto);

               courseDtos.add(courseDto);
           }

           return  courseDtos;

       }catch (Exception e){
           return  null;
       }

    }

    @Override
    public CourseDto findById(Long idCourse){
        try {
            CourseEntity courseEntity = courseRepository.findByIdCourse(idCourse);
            if (courseEntity==null){
                return null;
            }else{
                CourseDto courseDto = new CourseDto();
                BeanUtils.copyProperties(courseEntity,courseDto);

                return courseDto;
            }

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto){

        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(courseDto,courseEntity);

        CourseDto createdCourse = new CourseDto();
        BeanUtils.copyProperties(courseRepository.save(courseEntity) , createdCourse);

        return createdCourse;

    }
//
    @Override
    public boolean deleteCourse(Long idCourse){

        try{
            CourseEntity courseEntity = courseRepository.findByIdCourse(idCourse);
            if (courseEntity == null){
                return false;
            }else {
                courseRepository.delete(courseEntity);
                return true;
            }

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public CourseDto updateCourse(Long idCourse , CourseDto courseDto){
        CourseEntity courseEntity = courseRepository.findByIdCourse(idCourse);

        if (courseEntity == null){
            return null;
        }else {
            CourseEntity updateEntity = new CourseEntity();
            BeanUtils.copyProperties(courseDto,updateEntity);
            updateEntity.setIdCourse(idCourse);

            CourseDto updatedCourse = new CourseDto();
            BeanUtils.copyProperties(courseRepository.save(updateEntity),updatedCourse);

            return updatedCourse;
        }
    }
}
