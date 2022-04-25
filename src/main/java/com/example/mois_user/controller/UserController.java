package com.example.mois_user.controller;

import com.example.mois_user.domain.User;
import com.example.mois_user.repository.UserRepository;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/users")
public class UserController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}