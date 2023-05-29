package com.evaluation.backend.service;

import com.evaluation.backend.dto.CourseDTO;
import com.evaluation.backend.model.Course;
import com.evaluation.backend.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    Logger logger = LoggerFactory.getLogger(CourseService.class);

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /*
     Get all courses from database and convert them into CourseDTO
    */
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> courses = new ArrayList<>();
        courseRepository.findAll()
                .forEach(course -> {
                    courses.add(new CourseDTO(course));
                });
        return courses;
    }
}
