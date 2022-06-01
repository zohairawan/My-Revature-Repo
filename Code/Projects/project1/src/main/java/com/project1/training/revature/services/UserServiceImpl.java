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
    public ResponseEntity<String> deleteUser(int userId) {
        ResponseEntity responseEntity;
        if(userExists(userId)) {
            userDAO.deleteById(userId);
            return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String> ("User does not exist, delete unsuccessful", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}