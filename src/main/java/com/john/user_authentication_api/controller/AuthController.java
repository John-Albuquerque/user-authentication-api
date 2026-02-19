package com.john.user_authentication_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(RequestBody AuthenticationDTO authDto){

    }
}
