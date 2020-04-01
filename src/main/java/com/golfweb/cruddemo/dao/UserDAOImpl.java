package com.golfweb.cruddemo.dao;

import com.golfweb.cruddemo.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
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

        ArrayList<User> list = (ArrayList) query.getResultList();
        for(User u : list) {
            System.out.println("This: " + u);
        }

        return list;
    }
}
