package com.project1.training.revature.services;

import com.project1.training.revature.model.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getItems();

    public Item getItem(int itemId);

    public void addItem(Item item);
}
