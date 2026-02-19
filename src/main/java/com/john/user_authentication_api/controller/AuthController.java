package com.john.user_authentication_api.controller;

import com.john.user_authentication_api.dto.AuthenticationDTO;
import com.john.user_authentication_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
        return ResponseEntity.ok(authService.login(authDto));
    }
}
