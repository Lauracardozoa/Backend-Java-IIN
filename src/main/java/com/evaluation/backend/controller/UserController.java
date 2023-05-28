package com.evaluation.backend.controller;

import com.evaluation.backend.dto.LoginDTO;
import com.evaluation.backend.dto.LoginResponseDTO;
import com.evaluation.backend.dto.RegisterDTO;
import com.evaluation.backend.dto.RegisterResponseDTO;
import com.evaluation.backend.service.LoginService;
import com.evaluation.backend.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private RegisterService registerService;

    private LoginService loginService;

    public UserController(RegisterService registerService, LoginService loginService) {
        this.registerService = registerService;
        this.loginService = loginService;
    }

    @PostMapping("/register")
    ResponseEntity<RegisterResponseDTO> registerNewUser(@RequestBody RegisterDTO newRegister){
        return registerService.registerNewUser(newRegister);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDto){
        return loginService.login(loginDto);
    }

}
