package com.example.mois_user.service;

import com.example.mois_user.domain.Address;
import com.example.mois_user.exception.InternalErrorException;
import com.example.mois_user.exception.UserAlreadyExistsException;
import com.example.mois_user.payload.response.MessageResponse;
import com.example.mois_user.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address createAddress(String postCode, String city, String street) {
        Address address = new Address();
        address.setPostCode(postCode);
        address.setCity(city);
        address.setStreet(street);

        try {
            address = addressRepository.save(address);
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }

        return address;
    }
}
