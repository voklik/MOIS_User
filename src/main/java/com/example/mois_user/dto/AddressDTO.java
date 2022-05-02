package com.example.mois_user.dto;

import lombok.Data;

@Data
public class AddressDTO {

    Long id;
    String city;
    String postCode;
    String street;

}