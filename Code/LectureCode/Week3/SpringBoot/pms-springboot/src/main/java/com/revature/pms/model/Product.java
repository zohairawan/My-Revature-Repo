/**
 * Model package stores your POJO's
 */

package com.revature.pms.model;

import lombok.*;

//Comes from lombok, a 3rd party library, which is used to reduce boiler plate codes
//Generates @Getter, @Setter, @ToString(), and @EqualsAndHashCode()
@Data
//Generate constructor with all parameters
@AllArgsConstructor
//Generate constructor with no parameters(default constructor)
@NoArgsConstructor
public class Product {

    //Instance Variables
    private int productId;
    private String productName;
    private int qoh;
    private int price;
}
