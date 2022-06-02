/**
 * This is the template for our cart object and cart table
 */

package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "carts", schema = "projectone")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int cartId;

    @ManyToMany
    @JoinTable(name = "from_cart", schema = "projectone",
        joinColumns = @JoinColumn(name = "carteyed", referencedColumnName = "cartId"),
        inverseJoinColumns = @JoinColumn(name = "itemeyed", referencedColumnName = "itemId"))
    private List<Item> itemList;
}