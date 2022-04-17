package com.example.mois_user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity @Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address implements Serializable {

    @Id
    @Column(name = "IDAddress")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "City")
    @NotBlank(message = "Město nesmí být prázdné.")
    String city;

    @Column(name = "post_code")
    @NotBlank(message = "PSČ nesmí být prázdné.")
    String postCode;

    @Column(name = "street")
    @NotBlank(message = "Název ulice nesmí být prázdné.")
    String street;
}