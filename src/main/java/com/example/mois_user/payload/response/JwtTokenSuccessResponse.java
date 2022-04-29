package com.example.mois_user.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtTokenSuccessResponse {

    private String jwt;
    private long userId;
    private String email;
    private String role;

}