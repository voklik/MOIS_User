package com.example.mois_user.controller;

import com.example.mois_user.domain.User;
import com.example.mois_user.repository.UserRepository;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*@DeleteMapping("/{id}")
    public ResponseEntity<User> deleteClientUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }*/

}