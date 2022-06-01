/**
 * Controller class is meant accept HTTP methods like: Get, Post, Put, Delete
 * We will use Postman app to send HTTP methods(Get,Post,Put,Delete) and those requests will be mapped to methods inside this class
 * Controller is the API layer
 * Postman ---> Controller
 */

package com.project1.training.revature.controller;

import com.project1.training.revature.model.User;
import com.project1.training.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/////ME ABOVE TUFAIL BELOW
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.training.revature.annotations.Authorized;
import com.project1.training.revature.model.Role;
import com.project1.training.revature.model.User;
import com.project1.training.revature.services.AuthorizationService;
import com.project1.training.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    //TUFAIL
    @Autowired
    private AuthorizationService authorizationService;

    // 1.Register new users
    // http://localhost:8089/users/registerUser
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Delete existing user
    // http://localhost:8089/users/deleteUser
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
        return userService.deleteUser(userId);
    }

    // 3.Get all users
    // http://localhost:8089/users/getUsers
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //TUFAIL
    @Authorized(allowedRoles = {Role.ADMIN})
    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id) {
        authorizationService.guardByUserId(id);

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User u) {

        return ResponseEntity.accepted().body(userService.insert(u));
    }


    @PutMapping
    @Authorized(allowedRoles = {Role.ADMIN, Role.CUSTOMER, Role.CUSTOMER})
    public ResponseEntity<User> update(@RequestBody User u) {
        authorizationService.guardByUserId(u.getUserId());
        // We will also check if this resource belongs to the User, even if they pass the @Authorized annotation

        return ResponseEntity.accepted().body(userService.update(u));
    }

    @Authorized(allowedRoles = {Role.ADMIN})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if(userService.delete(id)) {
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.noContent().build();
    }
}
