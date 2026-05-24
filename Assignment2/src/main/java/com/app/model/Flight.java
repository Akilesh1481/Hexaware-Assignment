package com.app.model;

public class Flight {

    private int id;
    private String flightName;
    private String source;
    private String destination;
    private double price;

    public Flight() {
    }

    public Flight(int id, String flightName, String source, String destination, double price) {

        this.id = id;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}