/**
 * Controller ---> Service
 */

package com.project1.training.revature.services;

import com.project1.training.revature.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public boolean userExists(int userId);
    public ResponseEntity<String> registerUser(User user);
    public ResponseEntity<String> deleteUser(int userId);
    public List<User> getUsers();

    //TUFAIL
    List<User> findAll();
    User login(String username, String password);
    void logout();
    User findById(int id);
    User insert(User u);
    User update(User u);
    boolean delete(int id);
}
