package com.example.Expense.Tracker.Controller;

import com.example.Expense.Tracker.dto.request.LoginRequest;
import com.example.Expense.Tracker.dto.request.RegisterRequest;
import com.example.Expense.Tracker.dto.response.AuthResponse;
import com.example.Expense.Tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        AuthResponse response = userService.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}