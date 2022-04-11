package com.example.mois_user.payload.request;

import com.example.mois_user.annotation.PasswordMatches;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignUpRequest {

    @NotBlank(message = "User email is required")
    @Email(message = "It should have email format")
    private String email;

    private String phoneNumber;

    @NotEmpty(message = "Please enter your first name")
    private String firstName;

    @NotEmpty(message = "Please enter your last name")
    private String lastName;

    @Size(min = 6)
    @NotEmpty(message = "Password is required")
    private String password;

    private String confirmPassword;

    private String city;

    private String postCode;

    private String streetName;

    private String streetNumber;

}