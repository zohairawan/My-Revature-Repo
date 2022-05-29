/**
 * Controller class is meant to contain HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those methods will be sent here to actually perform those operations
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.Item;
import com.project1.training.revature.model.User;
import com.project1.training.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    // 1.Register new users
    // http://localhost:8085/user/registerUser
    @PostMapping("registerUser")
    public String registerUser() {
        return "User has been added";
    }

    //Returns list of all items
    // http://localhost:8085/user/getItems
    @GetMapping("/getItems")
    public List<Item> getItems() {
        return userService.getItems();
    }

    //Returns one item based on Id
    // http://localhost:8085/user/getItem/
    @GetMapping("/getItem/{itemId}")
    public Item getItem(@PathVariable("itemId") int itemId) {
        return userService.getItem(itemId);
    }

    //Adds an item
    // http://localhost:8085/user/addItem/
    @PostMapping("/addItem")
    public String addItem(@RequestBody Item item) {
        userService.addItem(item);
        return "Item added successfully";
    }
}
