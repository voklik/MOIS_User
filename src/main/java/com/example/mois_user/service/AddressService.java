package com.example.mois_user.service;

import com.example.mois_user.domain.Address;
import com.example.mois_user.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        }

        return address;
    }
}
