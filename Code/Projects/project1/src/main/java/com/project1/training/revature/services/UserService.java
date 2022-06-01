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
    Object findAll();
    Object login(String username, String password);
    void logout();
    Object findById(int id);
    Object insert(User u);
    User update(User u);
    ResponseEntity<Void> delete(int id);
}
