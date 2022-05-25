package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Component
public class Item {

    //Instance Variables
    private int id;
    private String name;
    private double price;
}
