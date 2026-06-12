package com.itsupport.ticketingsystem.controller;

import com.itsupport.ticketingsystem.entity.User;
import com.itsupport.ticketingsystem.security.JwtUtil;
import com.itsupport.ticketingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    // Now we use the Service instead of the Repository directly
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
        try {
            // 1. Fetch user via the Service layer
            User user = userService.getUserByEmail(loginRequest.getEmail());

            // 2. Check if passwords match
            if (user.getPasswordHash().equals(loginRequest.getPasswordHash())) {
                String token = jwtUtil.generateToken(user.getEmail());
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }

        } catch (RuntimeException e) {
            // If the Service throws a "User not found" error, we catch it here
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}