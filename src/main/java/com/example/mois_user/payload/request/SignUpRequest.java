package com.example.mois_user.payload.request;

import com.example.mois_user.annotation.PasswordMatches;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignUpRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Bad email format")
    private String email;

    private String phoneNumber;

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Size(min = 6)
    @NotBlank(message = "Password cannot be empty")
    private String password;

    private String confirmPassword;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "Post code cannot be empty")
    private String postCode;

    @NotBlank(message = "Street cannot be empty")
    private String street;

}