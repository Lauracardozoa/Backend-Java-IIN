package com.evaluation.backend.dto;

public class RegisterDTO {
    private String fullName;
    private String email;
    private String password;
    private String country;

    public RegisterDTO(String fullName, String email, String password, String country) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.country = country;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
