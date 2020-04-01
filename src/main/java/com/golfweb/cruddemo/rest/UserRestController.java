package com.golfweb.cruddemo.rest;

import com.golfweb.cruddemo.dao.UserDAO;
import com.golfweb.cruddemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserDAO userDAO;

    @Autowired
    public UserRestController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/employees")
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
