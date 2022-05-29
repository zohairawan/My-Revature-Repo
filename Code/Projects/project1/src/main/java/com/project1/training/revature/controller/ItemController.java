/**
 * Controller class is meant accept HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those requests will be mapped to methods inside this class
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.Item;
import com.project1.training.revature.services.ItemService;
import com.project1.training.revature.services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    ItemService itemService;

    //Returns list of all items
    // http://localhost:8089/user/getItems
    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    //Returns one item based on Id
    // http://localhost:8089/user/getItem/
    @GetMapping("/getItem/{itemId}")
    public Item getItem(@PathVariable("itemId") int itemId) {
        return itemService.getItem(itemId);
    }

    //Adds an item
    // http://localhost:8089/user/addItem/
    @PostMapping("/addItem")
    public String addItem(@RequestBody Item item) {
        itemService.addItem(item);
        return "Item added successfully";
    }
}
