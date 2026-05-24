package com.app.service;

import com.app.model.Booking;
import com.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public void insertBooking(Booking booking) {
        repository.insertBooking(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.getAllBookings();
    }

    public void deleteBooking(int id) {
        repository.deleteBooking(id);
    }
}