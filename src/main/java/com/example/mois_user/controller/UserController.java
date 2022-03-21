package com.example.mois_user.controller;

import com.example.mois_user.domain.User;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = {"", "/"})
    public List<User> getAll() {
        List<User> users = userService.getAllUsers();
        return users;
    }





}
