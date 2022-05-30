/**
 * Service ---> ServiceImpl
 */

package com.project1.training.revature.services;

import com.project1.training.revature.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "john@yahoo.com", "pswd"),
            new User(2, "doe@yahoo.com", "1234"),
            new User(3, "test@yahoo.com", "hello"),
            new User(4, "demo@yahoo.com", "bye")
    ));

    @Override
    public boolean userExists(User user) {
        for(int i=0; i<users.size(); i++) {
            if(user.getUserId() == users.get(i).getUserId()) {
                return true;
            }
        }
        return false;
    }

    // 1.Register new users
    public String registerUser(User user) {
        return "Registered user: " + user + " successfully";
    }
}