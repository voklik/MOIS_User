package com.example.mois_user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "IDUser")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    @Email(message = "Nesprávný formát emailu.")
    @NotBlank(message = "Emailová adresa nesmí být prázdná.")
    private String email;

    @Column(name = "PasswordUser")
    @NotBlank(message = "Heslo nesmí být prázdné.")
    private String password;

    @Column(name = "FirstName")
    @NotBlank(message = "Jméno nesmí být prázdné.")
    private String firstName;

    @Column(name = "LastName")
    @NotBlank(message = "Příjmení nesmí být prázdné.")
    private String lastName;

    @Column(name = "phone")
    @Pattern(regexp = "^(([\\+][0-9]{3})?[\\s]?[0-9]{3}[\\s]?[0-9]{3}[\\s]?[0-9]{3})?$", message = "Špatný formát telefonního čísla.")
    private String phoneNumber;

    @Column(name = "Actives")
    private boolean active;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDRole", referencedColumnName = "IDRole")
    private Role role;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDAddress", referencedColumnName = "IDAddress")
    private Address address;
}