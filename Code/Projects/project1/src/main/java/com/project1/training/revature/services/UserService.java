/**
 * Controller ---> Service
 */

package com.project1.training.revature.services;

import com.project1.training.revature.model.User;

public interface UserService {
    public boolean userExists(int userId);
    public String registerUser(User user);
    public String deleteUser(int userId);
}
