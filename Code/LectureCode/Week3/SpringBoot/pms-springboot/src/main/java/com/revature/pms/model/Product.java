package com.revature.pms.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    //Instance Variables
    private int productId;
    private String productName;
    private int qoh;
    private int price;
}
