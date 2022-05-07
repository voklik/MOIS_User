package com.example.mois_user.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {

    Long id;

    @Email(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Špatný formát emailu")
    String email;

    @NotBlank(message = "Jméno nesmí být prázdné")
    String firstName;

    @NotBlank(message = "Příjmení nesmí být prázdné")
    String lastName;

    @Pattern(regexp = "^([\\+][ ]?[0-9]{3})?[ ]?[0-9]{3}[ ]?[0-9]{3}[ ]?[0-9]{3}$")
    String phoneNumber;

    boolean isActive;

    String roleName;

    AddressDTO address;

}