/**
 * Controller class is meant accept HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those requests will be mapped to methods inside this class
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.Item;
import com.project1.training.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    ItemService itemService;

    // Adds an item
    // http://localhost:8089/items/addItem/
    @PostMapping("/addItem")
    public String addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    // Returns list of all items
    // http://localhost:8089/items/getItems
    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    // Returns one item based on Id
    // http://localhost:8089/items/getItem/
    @GetMapping("/getItem/{itemId}")
    public Item getItem(@PathVariable("itemId") int itemId) {
        return null;
    }
}
