/**
 * This is the template for our cart object and cart table
 */

package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private int cartId;
    private int itemId;
    private int userId;
}
