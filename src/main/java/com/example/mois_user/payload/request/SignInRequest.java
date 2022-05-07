package com.example.mois_user.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInRequest {

    @NotBlank(message = "Email cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

}