package com.evaluation.backend.dto;

public class LoginResponseDTO extends ResponseDTO{

    private Integer id;

    private String email;
    public LoginResponseDTO(String message) {
        super(message);
    }

    public LoginResponseDTO(String message, Integer id, String email) {
        super(message);
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
