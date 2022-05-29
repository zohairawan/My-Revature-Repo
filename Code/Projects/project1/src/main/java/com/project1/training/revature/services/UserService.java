package com.project1.training.revature.services;

import com.project1.training.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserService {
    private List<Item> items = Arrays.asList(
            new Item(1, "Laptop", 455),
            new Item(2, "Keyboard", 105),
            new Item(3, "PS5", 800),
            new Item(4, "Xbox1", 650),
            new Item(5, "PS2", 200),
            new Item(6, "NintendoDS", 250)
    );

    public Item getItem(int itemId) {
        for(int i=0; i < items.size(); i++) {
            if(itemId == items.get(i).getItemId()) {
                return items.get(i);
            }
        }
        return null;
        //return items.stream().filter(i -> i.getItemId() == itemId).findFirst().get();
    }

    public List<Item> getItems() {
        return items;
    }
}