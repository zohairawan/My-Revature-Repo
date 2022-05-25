package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Component
public class Cart {

    //Instance Variables
    private int id;
    private int item_id;
    private int user_id;
}
