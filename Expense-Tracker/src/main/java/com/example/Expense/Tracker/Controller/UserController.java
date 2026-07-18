package com.example.Expense.Tracker.Controller;

import com.example.Expense.Tracker.dto.response.UserResponse;
import com.example.Expense.Tracker.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}