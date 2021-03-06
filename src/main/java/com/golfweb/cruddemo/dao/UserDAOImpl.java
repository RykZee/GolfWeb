package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.User;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("from User", User.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public User find(int id) throws NotFoundException {
        Session session = entityManager.unwrap(Session.class);

        User user = session.get(User.class, id);
        if(user == null) {
            throw new NotFoundException("Id couldn't be found");
        }

        return user;
    }

    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from User where id=:userId");
        query.setParameter("userId", id);

        query.executeUpdate();
    }
}
