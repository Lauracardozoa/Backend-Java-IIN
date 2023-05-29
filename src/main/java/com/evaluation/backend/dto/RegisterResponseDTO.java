package com.evaluation.backend.dto;

/*
     DTO used for response with full name and email when the register is successful or a failure message otherwise
*/
public class RegisterResponseDTO extends ResponseDTO{
    private String fullName;

    private String email;

    public RegisterResponseDTO(String message) {
        super(message);
    }

    public RegisterResponseDTO(String message, String fullName, String email) {
        super(message);
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
