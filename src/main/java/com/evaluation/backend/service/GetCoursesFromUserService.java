package com.evaluation.backend.service;

import com.evaluation.backend.dto.CourseDTO;
import com.evaluation.backend.model.Course;
import com.evaluation.backend.model.User;
import com.evaluation.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GetCoursesFromUserService {

    Logger logger = LoggerFactory.getLogger(GetCoursesFromUserService.class);
    private UserRepository userRepository;

    public GetCoursesFromUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<CourseDTO> getCoursesFromUser(Integer userId) {
        List<CourseDTO> courseList = new ArrayList<>();
        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isPresent()) {
            Set<Course> courses = optionalUser.get().getCourses();
            courses.forEach(course -> {
                courseList.add(new CourseDTO(course));
            });
        }
        return courseList;
    }
}
