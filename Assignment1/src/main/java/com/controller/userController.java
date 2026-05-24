package com.controller;

import com.enums.Role;
import com.model.user;
import com.service.userService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class userController {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        userService service = new userService();
        while(true) {
            System.out.println("\n===== MENU =====");

            System.out.println("1. Insert User");
            System.out.println("2. Get All Users");
            System.out.println("3. Get Users By Role");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");
            int choice = scan.nextInt();
            switch(choice) {

                case 1:
                    scan.nextLine();
                    System.out.print("Enter Email : ");
                    String email = scan.nextLine();
                    System.out.print("Enter Name : ");
                    String name = scan.nextLine();
                    System.out.print("Enter Password : ");
                    String password = scan.nextLine();
                    System.out.print("Enter Phone : ");
                    int phone = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Role (admin/owner/user) : ");
                    String roleInput = scan.nextLine();
                    Role role = Role.valueOf(roleInput);
                    user obj = new user(
                            0, email, name, password, phone, role
                    );
                    service.insertUser(obj);
                    break;

                case 2:
                    List<user> list = service.getAllUser();
                    for(user u : list) {
                        System.out.println("ID : " + u.getId());
                        System.out.println("Email : " + u.getEmail());
                        System.out.println("Name : " + u.getName());
                        System.out.println("Password : " + u.getPassword());
                        System.out.println("Phone : " + u.getPhone());
                        System.out.println("Role : " + u.getRole());
                        System.out.println("-------------------");
                    }
                    break;

                case 3:
                    scan.nextLine();
                    System.out.print("Enter Role : ");
                    String roleSearch = scan.nextLine();
                    List<user> roleList = service.getUserByRole(roleSearch);
                    for(user u : roleList) {
                        System.out.println("ID : " + u.getId());
                        System.out.println("Email : " + u.getEmail());
                        System.out.println("Name : " + u.getName());
                        System.out.println("Password : " + u.getPassword());
                        System.out.println("Phone : " + u.getPhone());
                        System.out.println("Role : " + u.getRole());
                        System.out.println("-------------------");
                    }
                    break;

                case 4:
                    System.out.print("Enter User ID : ");
                    int id = scan.nextInt();
                    service.deleteUser(id);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}