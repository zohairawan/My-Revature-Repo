/**
 * This is the template for our user object and user table
 */

package com.project1.training.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;

//Generates @ToString, @EqualsAndHashCode, @Getter, @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "users", schema = "projectone")
public class User {
    @Id
    //@SequenceGenerator(name="mysequenceUser", initialValue=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequenceUser") //HE HAS GENTYPE IDENTITY
    private int userId;
    private String username;
    private String password;
    private Role role;
    //private Cart cart;
}
