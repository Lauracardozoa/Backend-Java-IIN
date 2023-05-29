package com.evaluation.backend.service;

import com.evaluation.backend.dto.ResponseDTO;
import com.evaluation.backend.dto.SubscribeRequestDTO;
import com.evaluation.backend.model.Course;
import com.evaluation.backend.model.User;
import com.evaluation.backend.repository.CourseRepository;
import com.evaluation.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    Logger logger = LoggerFactory.getLogger(SubscriptionService.class);
    private UserRepository userRepository;

    private CourseRepository  courseRepository;

    public SubscriptionService(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    /*
     1. Check if a user with the given userId and a course with the given courseId exists in the database
     2. If not return an error message
     3. If them exist then return a success message
    */
    public ResponseEntity<ResponseDTO> subscribe(SubscribeRequestDTO request){
        ResponseEntity<ResponseDTO> response;
        Integer userId = request.getUserId();
        Integer courseId = request.getCourseId();
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if(optionalUser.isPresent()){ // If user with userId exists
                Optional<Course> optionalCourse = courseRepository.findById(courseId);
                if(optionalCourse.isPresent()){ // If course with courseId exists
                    User user = optionalUser.get();
                    Course course = optionalCourse.get();
                    user.addCourse(course); // add the course
                    userRepository.save(user);
                    response = new ResponseEntity<>(new ResponseDTO("User subscribe to course"), HttpStatus.OK);
                    logger.info("Subscribe user with id " + userId + " to course " + courseId);
                }
                else{
                    throw new Exception("Course do not exist");
                }
            }
            else{
                throw new Exception("User do not exist");
            }
        }catch (Exception e){
            response = new ResponseEntity<>(new ResponseDTO("Failed to subscribe user to course"), HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error("Failed to subscribe user to course "+ e.getMessage());
        }
        return response;
    }

    /*
     1. Check if a user with the given userId and a course with the given courseId exists in the database
     2. If not return an error message
     3. If them exist then return a success message
    */
    public ResponseEntity<ResponseDTO> unsubscribe(SubscribeRequestDTO request){
        ResponseEntity<ResponseDTO> response;
        Integer userId = request.getUserId();
        Integer courseId = request.getCourseId();
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if(optionalUser.isPresent()){ // If user with userId exists
                Optional<Course> optionalCourse = courseRepository.findById(courseId);
                if(optionalCourse.isPresent()){ // If course with courseId exists
                    User user = optionalUser.get();
                    Course course = optionalCourse.get();
                    user.removeCourse(course); // remove the course
                    userRepository.save(user);
                    response = new ResponseEntity<>(new ResponseDTO("User unsubscribe to course"), HttpStatus.OK);
                    logger.info("Unsubscribe user with id " + userId + " to course " + courseId);
                }
                else{
                    throw new Exception("Course do not exist");
                }
            }
            else{
                throw new Exception("User do not exist");
            }
        }catch (Exception e){
            response = new ResponseEntity<>(new ResponseDTO("Failed to unsubscribe user to course"), HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error("Failed to subscribe user to course "+ e.getMessage());
        }
        return response;
    }

}
