package com.project1.training.revature.services;

import com.project1.training.revature.model.Item;

import java.util.List;

public interface ItemService {
    public boolean itemExists(int itemId);
    public String addItem(Item item);
    public List<Item> getItems();
}
