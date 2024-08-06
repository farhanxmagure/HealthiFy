package com.magure.HealthiFy.Security.Data.Request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}