package com.golfweb.cruddemo.rest;

import com.golfweb.cruddemo.dao.MessageDAO;
import com.golfweb.cruddemo.entity.Message;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/messageapi")
public class MessageRestController {

    private MessageDAO messageDAO;

    @Autowired
    public MessageRestController(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @CrossOrigin
    @GetMapping("/messages")
    public List<Message> findAllMessages() {
        return messageDAO.findAll();
    }

    @CrossOrigin
    @GetMapping("/messages/{messageId}")
    public Message getMessage(@PathVariable int messageId) {
        Message message;
        try {
            message = messageDAO.find(messageId);
        } catch (NotFoundException e) {
            throw new RuntimeException("Could not find message with id " + messageId);
        }
        return message;
    }

    @CrossOrigin
    @GetMapping("messages/receiver/{receiverId}")
    public List<Message> getMessages(@PathVariable int receiverId) {
        return messageDAO.findReceiver(receiverId);
    }

    @CrossOrigin
    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message) {
        // Message id set to 0 will always save as a new user instead of updating in case of error
        message.setMessageId(0);
        message.setTimestamp(new Date());
        messageDAO.saveOrUpdate(message);
        return message;
    }

    @CrossOrigin
    @PutMapping("/messages")
    public Message editMessage(@RequestBody Message message) {
        // If message can't be found a new message will be created
        message.setTimestamp(new Date());
        messageDAO.saveOrUpdate(message);
        return message;
    }

    @CrossOrigin
    @DeleteMapping("/messages/{messageId}")
    public Message deleteMessage(@PathVariable int messageId) {
        Message message;
        try {
            message = messageDAO.find(messageId);
        } catch (NotFoundException e) {
            throw new RuntimeException("Message couldn't be deleted with id " + messageId);
        }
        messageDAO.delete(messageId);
        return message;
    }
}
