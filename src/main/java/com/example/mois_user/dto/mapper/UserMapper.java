package com.example.mois_user.dto.mapper;

import com.example.mois_user.domain.User;
import com.example.mois_user.dto.AddressDTO;
import com.example.mois_user.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO userToDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setActive(user.isActive());
        userDTO.setRoleName(user.getRole().getName());

        AddressDTO address = new AddressDTO();
        address.setId(user.getAddress().getId());
        address.setPostCode(user.getAddress().getPostCode());
        address.setCity(user.getAddress().getCity());
        address.setStreet(user.getAddress().getStreet());

        userDTO.setAddress(address);

        return userDTO;
    }

}