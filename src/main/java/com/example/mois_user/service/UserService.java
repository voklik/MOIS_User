package com.example.mois_user.service;

import com.example.mois_user.domain.Address;
import com.example.mois_user.domain.User;
import com.example.mois_user.dto.UserDTO;
import com.example.mois_user.dto.mapper.UserMapper;
import com.example.mois_user.exception.InternalErrorException;
import com.example.mois_user.exception.UserAlreadyExistsException;
import com.example.mois_user.exception.UserNotFoundException;
import com.example.mois_user.payload.request.SignUpRequest;
import com.example.mois_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.mois_user.domain.util.Role.ADMIN_ROLE;
import static com.example.mois_user.domain.util.Role.USER_ROLE;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final AddressService addressService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public Page<UserDTO> getAllUsers(Pageable pageable, String searchText) {

        Page<User> pageUsers;

        if (searchText != null && !searchText.isEmpty()) {
            pageUsers = userRepository.findAll(pageable, searchText);
        } else {
            pageUsers = userRepository.findAll(pageable);
        }

        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> users = pageUsers.getContent();
        for (User user : users) {
            userDTOList.add(userMapper.userToDTO(user));
        }
        Page<UserDTO> pageUsersDTO = new PageImpl<>(userDTOList, pageable, userDTOList.size());

        return pageUsersDTO;
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException("User not found");
        return user.get();
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent())
            throw new UserNotFoundException("User " + email + " not found");
        return user.get();
    }

    public User createUser(SignUpRequest signUpRequest, boolean isAdmin) {

        Address address = addressService.createAddress(
                signUpRequest.getPostCode(),
                signUpRequest.getCity(),
                signUpRequest.getStreet());

        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
        user.setAddress(address);
        user.setActive(true);
        if (isAdmin) {
            user.setRole(roleService.getRoleByName(ADMIN_ROLE));
        } else {
            user.setRole(roleService.getRoleByName(USER_ROLE));
        }

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new UserAlreadyExistsException("The user " + user.getEmail() + " already exist. Please check credentials");
        }
    }

    public User updateUser(UserDTO userDTO) {
        User user = userRepository.getById(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.getAddress().setCity(userDTO.getAddress().getCity());
        user.getAddress().setPostCode(userDTO.getAddress().getPostCode());
        user.getAddress().setStreet(userDTO.getAddress().getStreet());

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

}