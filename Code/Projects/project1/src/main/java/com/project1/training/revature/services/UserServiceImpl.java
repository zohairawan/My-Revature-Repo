/**
 * Service ---> ServiceImpl
 */

package com.project1.training.revature.services;

import com.project1.training.revature.dao.UserDAO;
import com.project1.training.revature.model.Cart;
import com.project1.training.revature.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    // 1.Register new users
    public String registerUser(User user) {
        if(userExists(user.getUserId())) {
            return "Can't register user because they are already registered";
        }
        else {
            userDAO.save(user);
            return "Registered user: " + user + " successfully";
        }
    }

    @Override
    public boolean userExists(int userId) {
        return userDAO.existsById(userId);
    }
}