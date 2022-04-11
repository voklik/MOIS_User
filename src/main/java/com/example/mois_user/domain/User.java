package com.example.mois_user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;

@Entity @Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable, UserDetails {
    //TODO: validační anotace pro DTO
    @Id
    @Column(name = "IDUser")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "email")
    @Email(message = "Nesprávný formát emailu.")
    @NotBlank(message = "Emailová adresa nesmí být prázdná.")
    String email;

    @Column(name = "PasswordUser")
    @NotBlank(message = "Heslo nesmí být prázdné.")
    String password;

    @Column(name = "FirstName")
    @NotBlank(message = "Jméno nesmí být prázdné.")
    String firstName;

    @Column(name = "LastName")
    @NotBlank(message = "Příjmení nesmí být prázdné.")
    String lastName;

    @Column(name = "phone")
    @Pattern(regexp = "^(([\\+][0-9]{3})?[\\s]?[0-9]{3}[\\s]?[0-9]{3}[\\s]?[0-9]{3})?$", message = "Špatný formát telefonního čísla.")
    String phoneNumber;

    @Column(name = "Actives")
    boolean active;

    @Transient
    Collection<? extends GrantedAuthority> authorities;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDRole", referencedColumnName = "IDRole")
    Role role;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDAddress", referencedColumnName = "IDAddress")
    Address address;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}