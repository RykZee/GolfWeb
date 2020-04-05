package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.Message;
import javassist.NotFoundException;

import java.util.List;

public interface MessageDAO {

    public List<Message> findAll();

    public Message find(int id) throws NotFoundException;

    public void saveOrUpdate(Message message);

    public void delete(int id);
}
