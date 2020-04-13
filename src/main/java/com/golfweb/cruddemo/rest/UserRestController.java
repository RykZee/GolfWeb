package com.golfweb.cruddemo.rest;

import com.golfweb.cruddemo.dao.UserDAO;
import com.golfweb.cruddemo.entity.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserRestController {

    private UserDAO userDAO;

    @Autowired
    public UserRestController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    @CrossOrigin
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        User user;
        try {
            user = userDAO.find(userId);
        } catch (NotFoundException e) {
            throw new RuntimeException("Could not find user with user id " + userId);
        }

        return user;
    }

    @CrossOrigin
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        // Users id set to 0 will always save as a new user instead of updating in case of error
        user.setUserId(0);
        userDAO.saveOrUpdate(user);
        return user;
    }

    @CrossOrigin
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        // If user doesn't exist, a new user will be created
        userDAO.saveOrUpdate(user);
        return user;
    }

    @CrossOrigin
    @DeleteMapping("/users/{userId}")
    public User deleteUser(@PathVariable int userId) {
        User user;
        try {
            user = userDAO.find(userId);
        } catch (NotFoundException e) {
            throw new RuntimeException("User not found with user Id " + userId);
        }

        userDAO.delete(userId);
        return user;
    }
}
