package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.Message;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    private EntityManager entityManager;

    @Autowired
    public MessageDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Message> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Message", Message.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Message find(int id) throws NotFoundException {
        Session session = entityManager.unwrap(Session.class);

        Message message = session.get(Message.class, id);
        if(message == null) {
            throw new NotFoundException("Id couldn't be found");
        }

        return message;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Message message) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(message);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Message where id=:messageId");
        query.setParameter("messageId", id);

        query.executeUpdate();
    }
}
