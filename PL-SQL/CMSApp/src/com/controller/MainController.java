package com.controller;

import com.enums.Role;
import com.exception.UserNotFoundException;
import com.model.User;
import com.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("--------CMS: LOGIN----------");
        System.out.println("Enter Username ");
        String username = sc.next();
        System.out.println("Enter Password ");
        String password = sc.next();
        try {
            User user = userService.authenticateUser(username, password);
            System.out.println("Welcome " + user.getUsername() );
            System.out.println("Role is " + user.getRole());
            if(user.getRole().equals(Role.OFFICER)){
                while(true){
                    System.out.println("1. View Incidents"); //incidents for this logged-in user
                    System.out.println("2. Filter Incidents by Status ");
                    System.out.println("0. Exit");
                    int op = sc.nextInt();
                    if(op == 0) break; //exits the while loop
                    switch(op){
                        case 1:
                            // implement view incidents op here. (controller - service - repo )
                            break;
                        case 2:
                            System.out.println("Enter the status");
                            String statusVal = sc.next();
                            // implement filter incidents by status here
                            break;
                    }
                }
            }
            else
            if(user.getRole().equals(Role.STATION_HEAD) ){

            }
        } catch (SQLException | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /* I have this loggedIn user.
            - check role of this user
            - if role IS officer Then load Officer menu
            - if role IS station_head Then load station_head Menu
         */

    }
}