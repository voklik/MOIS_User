package com.example.mois_user.controller;

import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/users")
public class UserController {

    private final UserService userService;

}