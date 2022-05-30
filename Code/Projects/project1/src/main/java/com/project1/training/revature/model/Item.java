/**
 * This is the template for our item object and item table
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
@Entity
@Table(name = "Items", schema = "projectone")
public class Item {
    @Id
    private int itemId;
    private String itemName;
    private double itemPrice;
    private int stock;
}
