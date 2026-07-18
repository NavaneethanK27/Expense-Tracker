package com.example.Expense.Tracker.service;

import com.example.Expense.Tracker.dto.request.LoginRequest;
import com.example.Expense.Tracker.dto.request.RegisterRequest;
import com.example.Expense.Tracker.dto.response.AuthResponse;
import com.example.Expense.Tracker.dto.response.UserResponse;

public interface UserService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    UserResponse getUserById(Long id);
}