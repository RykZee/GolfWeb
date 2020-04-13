package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.Message;
import com.golfweb.cruddemo.entity.User;
import javassist.NotFoundException;

import java.util.List;

public interface MessageDAO {

    public List<Message> findAll();

    public Message find(int id) throws NotFoundException;

    public List<Message> findReceiver(int receiverId);

    public void saveOrUpdate(Message message);

    public void delete(int id);
}
