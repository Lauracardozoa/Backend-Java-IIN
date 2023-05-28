package com.evaluation.backend.service;

import com.evaluation.backend.dto.LoginDTO;
import com.evaluation.backend.dto.LoginResponseDTO;
import com.evaluation.backend.model.User;
import com.evaluation.backend.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<LoginResponseDTO> login(LoginDTO loginDTO){
        ResponseEntity<LoginResponseDTO> response;
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(email,password);
        if(optionalUser.isPresent()){
            LoginResponseDTO loginResponse = new LoginResponseDTO("User logged in",optionalUser.get().getId(), optionalUser.get().getEmail());
            response = new ResponseEntity<>(loginResponse, HttpStatus.OK);
            logger.info("User" +optionalUser.get().getEmail()+" logged in");
        }
        else{
            LoginResponseDTO loginResponse = new LoginResponseDTO("Failed to Login");
            response = new ResponseEntity<>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error("Failed to log in");
        }
        return response;
    }
}
