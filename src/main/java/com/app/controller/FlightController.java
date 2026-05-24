package com.app.controller;

import com.app.config.HibernateConfig;
import com.app.model.Booking;
import com.app.model.Flight;
import com.app.model.User;
import com.app.service.BookingService;
import com.app.service.FlightService;
import com.app.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class FlightController {

    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(HibernateConfig.class);

        FlightService flightService=context.getBean(FlightService.class);
        UserService userService=context.getBean(UserService.class);
        BookingService bookingService=context.getBean(BookingService.class);

        Scanner sc=new Scanner(System.in);

        while(true) {

            System.out.println("\n1.Add Flight\n2.View Flights\n3.Update Flight\n4.Delete Flight\n5.Add User\n6.View Users\n7.Delete User\n8.Add Booking\n9.View Bookings\n10.Delete Booking\n11.Exit");

            System.out.print("Enter Choice : ");

            int choice=sc.nextInt();

            switch(choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Flight Name : ");
                    String name=sc.nextLine();

                    System.out.print("Enter Source : ");
                    String source=sc.nextLine();

                    System.out.print("Enter Destination : ");
                    String destination=sc.nextLine();

                    System.out.print("Enter Price : ");
                    double price=sc.nextDouble();

                    flightService.insertFlight(new Flight(0,name,source,destination,price));

                    break;

                case 2:

                    List<Flight> flights=flightService.getAllFlights();

                    if(flights.isEmpty()) {
                        System.out.println("No Flights Available");
                    }
                    else {
                        for(Flight f:flights) {
                            System.out.println("Id : "+f.getId());
                            System.out.println("Flight : "+f.getFlightName());
                            System.out.println("Source : "+f.getSource());
                            System.out.println("Destination : "+f.getDestination());
                            System.out.println("Price : "+f.getPrice());
                            System.out.println("----------------");
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Flight Id : ");
                    int updateId=sc.nextInt();

                    System.out.print("Enter New Price : ");
                    double newPrice=sc.nextDouble();

                    flightService.updateFlight(updateId,newPrice);

                    break;

                case 4:

                    System.out.print("Enter Flight Id : ");
                    int deleteId=sc.nextInt();

                    flightService.deleteFlight(deleteId);

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String userName=sc.nextLine();

                    System.out.print("Enter Email : ");
                    String email=sc.nextLine();

                    System.out.print("Enter Password : ");
                    String password=sc.nextLine();

                    userService.insertUser(new User(0,userName,email,password));

                    break;

                case 6:

                    List<User> users=userService.getAllUsers();

                    if(users.isEmpty()) {
                        System.out.println("No Users Available");
                    }
                    else {
                        for(User u:users) {
                            System.out.println("Id : "+u.getId());
                            System.out.println("Name : "+u.getName());
                            System.out.println("Email : "+u.getEmail());
                            System.out.println("----------------");
                        }
                    }

                    break;

                case 7:

                    System.out.print("Enter User Id : ");
                    int userId=sc.nextInt();

                    userService.deleteUser(userId);

                    break;

                case 8:

                    sc.nextLine();

                    System.out.print("Enter Passenger Name : ");
                    String passengerName=sc.nextLine();

                    System.out.print("Enter Seat Number : ");
                    String seat=sc.nextLine();

                    bookingService.insertBooking(new Booking(0,passengerName,seat));

                    break;

                case 9:

                    List<Booking> bookings=bookingService.getAllBookings();

                    if(bookings.isEmpty()) {
                        System.out.println("No Bookings Available");
                    }
                    else {
                        for(Booking b:bookings) {
                            System.out.println("Id : "+b.getId());
                            System.out.println("Passenger : "+b.getPassengerName());
                            System.out.println("Seat : "+b.getSeatNumber());
                            System.out.println("----------------");
                        }
                    }

                    break;

                case 10:

                    System.out.print("Enter Booking Id : ");
                    int bookingId=sc.nextInt();

                    bookingService.deleteBooking(bookingId);

                    break;

                case 11:

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}
