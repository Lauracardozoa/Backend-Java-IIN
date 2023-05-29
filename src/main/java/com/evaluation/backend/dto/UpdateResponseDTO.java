package com.evaluation.backend.dto;

import com.evaluation.backend.model.User;

/*
     DTO used for a response after the update of a user
*/
public class UpdateResponseDTO extends ResponseDTO{

    User user;
    public UpdateResponseDTO(String message) {
        super(message);
    }

    public UpdateResponseDTO(String message, User user) {
        super(message);
        this.user = user;
    }

}
