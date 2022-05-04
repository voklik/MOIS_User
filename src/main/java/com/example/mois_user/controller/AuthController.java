package com.example.mois_user.controller;

import com.example.mois_user.domain.User;
import com.example.mois_user.payload.request.SignInRequest;
import com.example.mois_user.payload.request.SignUpRequest;
import com.example.mois_user.payload.response.JwtTokenSuccessResponse;
import com.example.mois_user.payload.response.MessageResponse;
import com.example.mois_user.security.JwtTokenProvider;
import com.example.mois_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/auth")
public class AuthController {
    
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    //private final ResponseErrorValidator responseErrorValidator;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody @Valid SignUpRequest signupRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }
        userService.createUser(signupRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@RequestBody @Valid SignInRequest loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return responseErrorValidator.getErrorResponse(bindingResult);
        }
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        User user = userService.getUserByEmail(loginRequest.getUsername()).get();
        return ResponseEntity.ok(new JwtTokenSuccessResponse(jwt, user.getId(), user.getEmail(), user.getRole().getName()));
    }

}