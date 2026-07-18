package com.example.Expense.Tracker.service;

import com.example.Expense.Tracker.Entity.User;
import com.example.Expense.Tracker.dto.request.LoginRequest;
import com.example.Expense.Tracker.dto.request.RegisterRequest;
import com.example.Expense.Tracker.dto.response.AuthResponse;
import com.example.Expense.Tracker.dto.response.UserResponse;
import com.example.Expense.Tracker.repsoitory.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return new AuthResponse("User registered successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        throw new UnsupportedOperationException("Login not implemented yet");

    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}