package com.evaluation.backend.service;

import com.evaluation.backend.dto.RegisterDTO;
import com.evaluation.backend.dto.RegisterResponseDTO;
import com.evaluation.backend.model.User;
import com.evaluation.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private Logger logger = LoggerFactory.getLogger(RegisterService.class);
    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     Register and new user and save it in the database, it checks if the email is not duplicate if its the case return
     an error message
    */
    public ResponseEntity<RegisterResponseDTO> registerNewUser(RegisterDTO newRegister) {
        User user = new User();
        RegisterResponseDTO registerResponseDTO;
        ResponseEntity<RegisterResponseDTO> response;
        user.setFullName(newRegister.getFullName());
        user.setEmail(newRegister.getEmail());
        user.setPassword(newRegister.getPassword());
        user.setCountry(newRegister.getCountry());
        try{
            userRepository.save(user);
            registerResponseDTO = new RegisterResponseDTO("Registration Done",user.getFullName(), user.getEmail());
            response = new ResponseEntity<RegisterResponseDTO>(registerResponseDTO, HttpStatus.CREATED);
            logger.info("Registration Done for user " + user.getFullName());
        }catch(Exception e){
            registerResponseDTO = new RegisterResponseDTO("Registration Failed try with another email");
            response = new ResponseEntity<RegisterResponseDTO>(registerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error("Registration Failed for user " + user.getFullName());
        }
        return response;

    }
}
