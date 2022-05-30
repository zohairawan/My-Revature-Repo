/**
 * This is the template for our cart object and cart table
 */

package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Entity
//@Table(name = "Carts", schema = "projectone")
public class Cart {
    @Id
    private int cartId;
    private int userId;
    private int itemId;
}