/**
 * Controller class is meant to contain HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those methods will be sent here to actually perform those operations
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.Item;
import com.project1.training.revature.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    // 1.Register new users
    // http://localhost:8085/user/registerUser
    @PostMapping("registerUser")
    public String registerUser() {
        return "User has been added";
    }

    @GetMapping("/getItems")
    public List<Item> getItems() {
        return Arrays.asList(
                new Item(1, "Laptop", 455),
                new Item(2, "Keyboard", 105),
                new Item(3, "PS5", 800),
                new Item(4, "Xbox1", 650)
        );
    }
}
