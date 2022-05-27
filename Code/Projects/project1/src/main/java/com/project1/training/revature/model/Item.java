/**
 * This is the template for our item object and item table
 */

package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int itemId;
    private String itemName;
    private double itemPrice;
}
