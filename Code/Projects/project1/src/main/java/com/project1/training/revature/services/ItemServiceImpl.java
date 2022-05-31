/**
 * Service ---> ServiceImpl
 */

package com.project1.training.revature.services;

import com.project1.training.revature.dao.ItemDAO;
import com.project1.training.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemDAO itemDAO;

    @Override
    public boolean itemExists(int itemId) {
        return itemDAO.existsById(itemId);
    }

    // Adds an item
    public ResponseEntity<String> addItem(Item item) {
        ResponseEntity responseEntity;
        if(itemExists(item.getItemId())) {
            return new ResponseEntity<String>("Cannot add item, already exists. You can increase item stock however", HttpStatus.CONFLICT);
        }
        else {
            itemDAO.save(item);
            return new ResponseEntity<String>("Item added successfully", HttpStatus.OK);
        }
    }

    // Get all items
    public List<Item> getItems() {
        return itemDAO.findAll();
    }

    //Increases stock of item
    public Item addStock(Item item) {
        if(itemExists(item.getItemId())) {
            itemDAO.save(item);
            return item;
        }
        else {
            System.out.println("Item does not exist");
            return null;
        }
    }
}
