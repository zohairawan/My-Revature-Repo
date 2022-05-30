/**
 * Controller ---> Service
 */

package com.project1.training.revature.services;

import com.project1.training.revature.model.User;

public interface UserService {
    public boolean userExists(User user);
    public String registerUser(User user);
}
