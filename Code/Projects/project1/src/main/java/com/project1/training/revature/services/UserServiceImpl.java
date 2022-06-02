/**
 * Service ---> ServiceImpl
 */

package com.project1.training.revature.services;

import com.project1.training.revature.dao.UserDAO;
import com.project1.training.revature.exceptions.UserNotFoundException;
import com.project1.training.revature.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private UserDAO userDAO;

    public boolean userExists(int userId) {
        return userDAO.existsById(userId);
    }

    public User login(String username, String password) {
        User exists = userDAO.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("No User with username = %s", username)));
        // Maybe change the above exception to instead be a UnsuccessfulLoginException

        // Check that the given password matches the password in the User object
        // Pretend that they were successful
        HttpSession session = req.getSession();
        session.setAttribute("currentUser", exists);

        return exists;
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
            return new ResponseEntity<String>("User: " + userId + " deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String> ("User: " + userId + " does not exist, delete unsuccessful", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }

    //TUFAIL
    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findById(int id) {
        return userDAO.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("No user with id = %d", id)));
    }

    public User insert(User u) {
        if(u.getUserId() != 0) {
            // This should be a custom exception class instead
            throw new RuntimeException("User ID must be zero to create a new User");
        }

        userDAO.save(u); // Modify the user with the new ID

        return u;
    }

    public User update(User u) {
        if(!userDAO.existsById(u.getUserId())) {
            throw new RuntimeException("User must already exist to update");
        }

        userDAO.save(u);

        HttpSession session = req.getSession(false); // They must have already been logged in, because we had our guard method

        User sessionUser = (User) session.getAttribute("currentUser");

        // If a User updated themselves, update the information in the session
        if(sessionUser.getUserId() == u.getUserId()) {
            session.setAttribute("currentUser", u);
        }

        return u;
    }

    public boolean delete(int id) {
        if(!userDAO.existsById(id)) {
            return false;
        }

        userDAO.deleteById(id);

        return true;
    }



    public void logout() {
        HttpSession session = req.getSession(false);
        if(session == null) {
            // No one was logged in
            return;
        }
        session.invalidate();
    }
}