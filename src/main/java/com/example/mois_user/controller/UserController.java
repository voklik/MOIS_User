package com.example.mois_user.controller;

import com.example.mois_user.domain.User;
import com.example.mois_user.dto.UserDTO;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/users")
public class UserController {

    private final UserService userService;

    @PutMapping("/df")
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    /*@GetMapping("/")
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable, String searchText) {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }*/

    @GetMapping({"/", "/{page}/{size}"})
    public ResponseEntity<Page<UserDTO>> getAllUsers(@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer size) {
        if(page == null && size == null ) {
            page = 1;
            size = 15;
        }
        return new ResponseEntity<>(userService.getAllUsers(
                PageRequest.of(
                        page, size, Sort.by("lastName").ascending()
                )
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}