package com.example.mois_user.dto;

import lombok.Data;

@Data
public class UserDTO {

    Long id;

    String email;

    String password;

    String firstName;

    String lastName;

    String phoneNumber;

    boolean active;
}