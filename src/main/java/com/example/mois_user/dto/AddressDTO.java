package com.example.mois_user.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class AddressDTO {

    Long id;

    @NotBlank(message = "Název města nesmí být prázdný")
    String city;

    @NotBlank(message = "PSČ nesmí být prázdné")
    @Pattern(regexp = "^[0-9]{3}[ ][0-9]{2}$", message = "PSČ musí být v následujícím formátu \"000 00\"")
    String postCode;

    @NotBlank(message = "Ulice nesmí být prázdná")
    String street;

}