package com.diabetic.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.dto.LoginRequest;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.serviceImpl.AuthServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
    	this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody @Valid LoginRequest request) {

        User user = authService.login(request.getEmail(),request.getPassword());
        return ResponseEntity.ok(user);
    }
}