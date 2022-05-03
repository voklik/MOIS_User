package com.example.mois_user.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInRequest {

    @NotBlank(message = "Email nemůže být prázdný")
    private String username;

    @NotBlank(message = "Heslo nemůže být prázdné")
    private String password;

}