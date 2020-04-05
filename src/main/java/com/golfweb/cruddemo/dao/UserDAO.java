package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User find(int id) throws NotFoundException;

    public void saveOrUpdate(User user);

    public void delete(int id);
}
