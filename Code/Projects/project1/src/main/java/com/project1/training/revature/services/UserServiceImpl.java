/**
 * Service ---> ServiceImpl
 */

package com.project1.training.revature.services;

import com.project1.training.revature.dao.UserDAO;
import com.project1.training.revature.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    public boolean userExists(int userId) {
        return userDAO.existsById(userId);
    }

    // 1.Register new users
    public ResponseEntity<String> registerUser(User user) {
        ResponseEntity responseEntity;
        if(userExists(user.getUserId())) {
            return new ResponseEntity<String>("Can't register user because they're already registered", HttpStatus.CONFLICT);
        }
        else {
            userDAO.save(user);
            return new ResponseEntity<String>("Registered user: " + user + " successfully", HttpStatus.OK);
        }
    }

    // Delete user
    public String deleteUser(int userId) {
        if(userExists(userId)) {
            userDAO.deleteById(userId);
            return "User deleted successfully";
        }
        else {
            return "User does not exist, delete unsuccessful";
        }
    }
}