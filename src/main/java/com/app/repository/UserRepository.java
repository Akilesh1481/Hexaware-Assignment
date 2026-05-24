package com.app.repository;

import com.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    SessionFactory sessionFactory;
    public void insertUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
        System.out.println("User Added");
    }
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("from User",User.class).list();
        session.close();
        return list;
    }
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class,id);
        if(user != null) {
            session.remove(user);
            System.out.println("User Deleted");
        }
        else {
            System.out.println("User Not Found");
        }
        tx.commit();
        session.close();
    }
}