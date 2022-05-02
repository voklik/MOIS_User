package com.example.mois_user.dto;

import lombok.Data;

@Data
public class UserDTO {

    Long id;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
    boolean active;
    AddressDTO address;
    RoleDTO role;

}