/**
 * Controller class is meant to contain HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those methods will be sent here
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    //GETS all items
    //http://localhost:8085/item/getItems
    @GetMapping("getItems")
    public String getAllItems() {
        return "Displaying all your items";
    }
}
