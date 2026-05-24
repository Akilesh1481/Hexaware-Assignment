package com.app.service;

import com.app.model.Flight;
import com.app.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository repository;

    public void insertFlight(Flight flight) {
        repository.insertFlight(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.getAllFlights();
    }

    public void updateFlight(int id,double price) {
        repository.updateFlight(id,price);
    }

    public void deleteFlight(int id) {
        repository.deleteFlight(id);
    }
}