package com.evaluation.backend.controller;

import com.evaluation.backend.dto.CourseDTO;
import com.evaluation.backend.model.Course;
import com.evaluation.backend.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }
}
