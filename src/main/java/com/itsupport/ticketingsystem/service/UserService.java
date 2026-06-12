package com.itsupport.ticketingsystem.service;

import com.itsupport.ticketingsystem.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerUser(User user);
    User getUserByEmail(String email);
}