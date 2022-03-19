package com.example.mois_user;

import com.example.mois_user.domain.Address;
import com.example.mois_user.repository.AddressRepository;
import com.example.mois_user.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
@EntityScan(basePackages = "/com.example.mois_user/domain")
public class MoisUserApplication {

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(MoisUserApplication.class, args);
    }



}
