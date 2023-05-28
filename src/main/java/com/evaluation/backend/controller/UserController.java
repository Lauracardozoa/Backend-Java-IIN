package com.evaluation.backend.controller;

import com.evaluation.backend.dto.RegisterDTO;
import com.evaluation.backend.dto.RegisterResponseDTO;
import com.evaluation.backend.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private RegisterService registerService;

    public UserController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    ResponseEntity<RegisterResponseDTO> registerNewUser(@RequestBody RegisterDTO newRegister){
        return registerService.registerNewUser(newRegister);
    }
}
