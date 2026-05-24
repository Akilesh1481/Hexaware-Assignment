package com.app.repository;

import com.app.model.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void insertBooking(Booking booking) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(booking);
        tx.commit();
        session.close();
        System.out.println("Booking Added");
    }

    public List<Booking> getAllBookings() {
        Session session = sessionFactory.openSession();
        List<Booking> list = session.createQuery("from Booking",Booking.class).list();

        session.close();
        return list;
    }
    public void deleteBooking(int id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Booking booking = session.get(Booking.class,id);
        if(booking != null) {
            session.remove(booking);
            System.out.println("Booking Deleted");
        }
        else {
            System.out.println("Booking Not Found");
        }
        tx.commit();
        session.close();
    }
}