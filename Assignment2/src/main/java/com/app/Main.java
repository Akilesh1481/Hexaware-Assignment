package com.app;

import com.app.config.AppConfig;
import com.app.repository.FlightRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FlightRepository repository = context.getBean(FlightRepository.class);
        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("\n===== FLIGHT MENU =====");
            System.out.println("1. Insert Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Update Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            switch(choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Flight Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Source : ");
                    String source = sc.nextLine();
                    System.out.print("Enter Destination : ");
                    String destination = sc.nextLine();
                    System.out.print("Enter Price : ");
                    double price = sc.nextDouble();
                    repository.insertFlight(name, source, destination, price);
                    break;

                case 2:
                        repository.getAllFlights();
                    break;

                case 3:
                    System.out.print("Enter Flight ID : ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Price : ");
                    double newPrice = sc.nextDouble();
                    repository.updateFlight(updateId, newPrice);
                    break;

                case 4:
                    System.out.print("Enter Flight ID : ");
                    int deleteId = sc.nextInt();
                    repository.deleteFlight(deleteId);
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}