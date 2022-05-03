package com.example.mois_user.payload.request;

import com.example.mois_user.annotation.PasswordMatches;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignUpRequest {

    @NotBlank(message = "Email je povinný")
    @Email(message = "Špatný formát")
    private String email;

    private String phoneNumber;

    @NotBlank(message = "Vložte své jméno")
    private String firstName;

    @NotBlank(message = "Vložte své příjmení")
    private String lastName;

    @Size(min = 6)
    @NotBlank(message = "Heslo je povinné")
    private String password;

    private String confirmPassword;

    @NotBlank(message = "Město je povinné")
    private String city;

    @NotBlank(message = "PSČ je povinné")
    private String postCode;

    @NotBlank(message = "Ulice je povinná")
    private String street;

}