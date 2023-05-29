package com.evaluation.backend.controller;

import com.evaluation.backend.dto.*;
import com.evaluation.backend.model.User;
import com.evaluation.backend.service.GetCoursesFromUserService;
import com.evaluation.backend.service.LoginService;
import com.evaluation.backend.service.RegisterService;
import com.evaluation.backend.service.UpdateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private RegisterService registerService;

    private LoginService loginService;

    private UpdateUserService updateUserService;

    private GetCoursesFromUserService getCoursesFromUserService;


    public UserController(RegisterService registerService, LoginService loginService, UpdateUserService updateUserService, GetCoursesFromUserService getCoursesFromUserService) {
        this.registerService = registerService;
        this.loginService = loginService;
        this.updateUserService = updateUserService;
        this.getCoursesFromUserService = getCoursesFromUserService;
    }

    /*
    Register a new user and save it in the database
     */
    @PostMapping("/register")
    ResponseEntity<RegisterResponseDTO> registerNewUser(@RequestBody RegisterDTO newRegister){
        return registerService.registerNewUser(newRegister);
    }

    /*
    Login a new user return the id and email of the logged user or an error message if the credentials are bad
     */
    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDto){
        return loginService.login(loginDto);
    }

    /*
    Update user info based on the id, not can update email or password
     */
    @PutMapping("/update/{id}")
    ResponseEntity<UpdateResponseDTO> update(@PathVariable Integer id, @RequestBody User updateUser){
        return updateUserService.update(id, updateUser);
    }

    /*
     Get all subscribed courses for a user based on his/her id
    */
    @GetMapping("/{id}/courses")
    List<CourseDTO> getCourses(@PathVariable Integer id){
        return getCoursesFromUserService.getCoursesFromUser(id);
    }
}
