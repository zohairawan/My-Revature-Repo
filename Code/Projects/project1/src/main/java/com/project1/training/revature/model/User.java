package com.project1.training.revature.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {


    //Instance Variables
    private int id;
    private String email;
    //How to omit getPassword()???
    private String password;
    private List<Item> CartList;
}
