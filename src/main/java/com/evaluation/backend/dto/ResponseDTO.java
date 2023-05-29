package com.evaluation.backend.dto;

/*
     DTO used for send messages in the responses
*/
public class ResponseDTO {
    private String message;

    public ResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
