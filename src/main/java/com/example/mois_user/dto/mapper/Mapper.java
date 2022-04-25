package com.example.mois_user.dto.mapper;

import com.example.mois_user.domain.Address;
import com.example.mois_user.domain.User;
import com.example.mois_user.dto.AddressDTO;
import com.example.mois_user.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserDTO userToDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setActive(user.isActive());

        return userDTO;
    }

    public User userToEntity(UserDTO userDTO) {

        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setActive(userDTO.isActive());

        return user;
    }

    public AddressDTO addressToDTO(Address address) {

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostCode(address.getPostCode());
        addressDTO.setStreet(address.getStreet());

        return addressDTO;
    }

    public Address addressToEntity(AddressDTO addressDTO) {

        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setCity(addressDTO.getCity());
        address.setPostCode(addressDTO.getPostCode());
        address.setStreet(addressDTO.getStreet());

        return address;
    }

}
