package com.example.mois_user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @Column(name = "IDAddress")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "City")
    @NotBlank(message = "Město nesmí být prázdné.")
    private String city;

    @Column(name = "PostCode")
    @NotBlank(message = "PSČ nesmí být prázdné.")
    private String postCode;

    @Column(name = "District")
    @NotBlank(message = "Název okresu nesmí být prázdné.")
    private String district;

    @Column(name = "StreetName")
    @NotBlank(message = "Název ulice nesmí být prázdné.")
    private String streetName;

    @Column(name = "StreetNumber")
    @NotBlank(message = "Popisné číslo nesmí být prázdné.")
    private String streetNumber;
}