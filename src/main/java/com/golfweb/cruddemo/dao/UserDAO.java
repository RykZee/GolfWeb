package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();
}
