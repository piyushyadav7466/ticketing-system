package com.itsupport.ticketingsystem.service;

import com.itsupport.ticketingsystem.entity.User;
import com.itsupport.ticketingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Tells Spring this is our business logic layer
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        // In a real production app, we would hash the password with BCrypt here!
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        // If the user doesn't exist, we throw an error that the Controller will catch
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}