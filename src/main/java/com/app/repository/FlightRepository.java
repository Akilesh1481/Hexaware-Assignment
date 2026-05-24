package com.app.repository;

import com.app.model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepository {

    @Autowired
    SessionFactory sessionFactory;
    public void insertFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(flight);
        tx.commit();
        session.close();
        System.out.println("Flight Added");
    }

    public List<Flight> getAllFlights() {
        Session session = sessionFactory.openSession();
        List<Flight> list = session.createQuery("from Flight",Flight.class).list();
        session.close();
        return list;
    }

    public void updateFlight(int id,double price) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Flight flight = session.get(Flight.class,id);
        if(flight != null) {
            flight.setPrice(price);
            session.merge(flight);
            System.out.println("Flight Updated");
        }
        else {
            System.out.println("Flight Not Found");
        }
        tx.commit();
        session.close();
    }

    public void deleteFlight(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Flight flight = session.get(Flight.class,id);
        if(flight != null) {
            session.remove(flight);
            System.out.println("Flight Deleted");
        }
        else {
            System.out.println("Flight Not Found");
        }
        tx.commit();
        session.close();
    }
}