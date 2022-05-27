/**
 * This is the template for our user object and user table
 */

package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String email;
    private String password;
    //private Cart cart;
}
