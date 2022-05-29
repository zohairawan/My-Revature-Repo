package com.project1.training.revature.services;

import com.project1.training.revature.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    // 1.Register new users
    public String registerUser(User user) {
        return "Registered user: " + user + " successfully";
    }
}