/**
 * Controller class is meant to contain HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those methods will be sent here to actually perform those operations
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    // 1.Register new users
    // http://localhost:8085/user/registerUser
    @PostMapping("registerUser")
    public String registerUser() {
        return "User has been added";
    }

    @PostMapping("registerUserTest")
    public User registerUserTest() {
        User user = new User(2, "doe@yahoo.com", "pswd1234");
        return user;
    }
}
