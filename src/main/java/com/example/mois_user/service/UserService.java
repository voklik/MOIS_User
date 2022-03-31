package com.example.mois_user.service;

import com.example.mois_user.domain.User;
import com.example.mois_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        Optional<User> user  = userRepository.findById(id);
        return user;
    }
}
