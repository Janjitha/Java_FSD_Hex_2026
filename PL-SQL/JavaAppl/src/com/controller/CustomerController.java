package com.controller;

import com.model.Customer;
import com.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerController {

    public static void main(String[] args) {
        // Reach out to Service class : Create an Object
        CustomerService customerService = new CustomerService();
        System.out.println("--- Displaying ALL Customers ----");
        List<Customer> list =  customerService.getAllCustomers();
        list.forEach(System.out :: println);

        try {
            System.out.println("--- Customers are displayed by the City ---");
            List<Customer> list1 = customerService.getCustomersByCity("");
            list1.forEach(System.out::println);
        }
        catch(SQLException e){
            System.out.println("ERROR: " + e.getSQLState() + ": " + e.getMessage());
        }
    }
}