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

    @PostMapping("/register")
    ResponseEntity<RegisterResponseDTO> registerNewUser(@RequestBody RegisterDTO newRegister){
        return registerService.registerNewUser(newRegister);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDto){
        return loginService.login(loginDto);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<UpdateResponseDTO> update(@PathVariable Integer id, @RequestBody User updateUser){
        return updateUserService.update(id, updateUser);
    }

    @GetMapping("/{id}/courses")
    List<CourseDTO> getCourses(@PathVariable Integer id){
        return getCoursesFromUserService.getCoursesFromUser(id);
    }
}
