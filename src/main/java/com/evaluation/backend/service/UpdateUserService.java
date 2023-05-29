package com.evaluation.backend.service;

import com.evaluation.backend.dto.UpdateResponseDTO;
import com.evaluation.backend.model.User;
import com.evaluation.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService {
    Logger logger = LoggerFactory.getLogger(UpdateUserService.class);

    private UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    Update info for a user, not update password, email, name or country set on the registration endpoint
    Return an error message if the id is invalid
     */
    public ResponseEntity<UpdateResponseDTO> update(Integer id, User updateUser) {
        ResponseEntity<UpdateResponseDTO> response;
        try{
            Optional<User> optionalUser = userRepository.findById(id);
            if(optionalUser.isPresent()) {
                User user = optionalUser.get();
                // Update only birthday, gender, address, phone number, preferred language and education level
                user.setBirthday(updateUser.getBirthday());
                user.setGender(updateUser.getGender());
                user.setAddress(updateUser.getAddress());
                user.setPhoneNumber(updateUser.getPhoneNumber());
                user.setPreferredLanguage(updateUser.getPreferredLanguage());
                user.setEducationLevel(updateUser.getEducationLevel());
                userRepository.save(user);
                UpdateResponseDTO updateResponseDTO = new UpdateResponseDTO("User updated successfully",user);
                response = new ResponseEntity<>(updateResponseDTO,HttpStatus.OK);
            }
            else{
                throw new Exception("User not found");
            }
        }catch (Exception e){
            UpdateResponseDTO updateResponseDTO = new UpdateResponseDTO("Error updating user, id not found.");
            response = new ResponseEntity<>(updateResponseDTO, HttpStatus.NOT_FOUND);
            logger.error("Error updating user " + updateUser.getEmail() + e.getMessage());
        }
        return response;
    }
}
