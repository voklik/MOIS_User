package com.example.mois_user.service;

import com.example.mois_user.domain.Address;
import com.example.mois_user.domain.User;
import com.example.mois_user.exception.UserExistException;
import com.example.mois_user.payload.request.SignUpRequest;
import com.example.mois_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.mois_user.domain.util.Role.USER_ROLE;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final AddressService addressService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public User createUser(SignUpRequest signUpRequest) {

        Address address = addressService.createAddress(
                signUpRequest.getPostCode(),
                signUpRequest.getCity(),
                signUpRequest.getStreetName(),
                signUpRequest.getStreetNumber());

        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
        user.setAddress(address);
        user.setActive(true);
        user.setRole(roleService.getRoleByName(USER_ROLE));

        try {
            //LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            //LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getEmail() + " already exist. Please check credentials");
        }
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /*public void deleteUser(Long id) {
        try {
            userRepository.delete(id);
        } catch (Exception e) {
            throw new UserExistException("The user is already deleted.");
        }
    }*/

}
