package com.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FlightRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void insertFlight(String name,String source, String destination, double price) {
        String query = "INSERT INTO flight(flight_name,source,destination,price) VALUES(?,?,?,?)";
        jdbcTemplate.update(query, name, source, destination, price);
        System.out.println("Flight Inserted");
    }
    public void getAllFlights() {
        String query = "SELECT * FROM flight";
        List<Map<String,Object>> flights = jdbcTemplate.queryForList(query);
        if(flights.isEmpty()) {
            System.out.println("No Flights Available");
            return;
        }
        for(Map<String,Object> flight : flights) {
            System.out.println("ID : " + flight.get("id"));
            System.out.println("Flight : " + flight.get("flight_name"));
            System.out.println("Source : " + flight.get("source"));
            System.out.println("Destination : " + flight.get("destination"));
            System.out.println("Price : " + flight.get("price"));
            System.out.println("----------------------");
        }
    }
    public void updateFlight(int id,double newPrice) {

        String query = "UPDATE flight SET price=? WHERE id=?";
        jdbcTemplate.update(query, newPrice, id);
        System.out.println("Flight Updated");
    }
    public void deleteFlight(int id) {
        String query = "DELETE FROM flight WHERE id=?";
        jdbcTemplate.update(query,id);
        System.out.println("Flight Deleted");
    }
}