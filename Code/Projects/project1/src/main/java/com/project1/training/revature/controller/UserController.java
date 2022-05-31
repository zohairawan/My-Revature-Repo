/**
 * Controller class is meant accept HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those requests will be mapped to methods inside this class
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.User;
import com.project1.training.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    // 1.Register new users
    // http://localhost:8089/user/registerUser
    @PostMapping("registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Delete existing user
    // http://localhost:8089/user/deleteUser
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
        return userService.deleteUser(userId);
    }
}
