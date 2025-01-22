package org.example.web;

import org.example.dao.Customer;
import org.example.service.Server;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Server server = new Server();
        server.addCustomer(new Customer(1, "John Doe", "123 Main St", "555-555-5555"));
        System.out.println(server.getCustomerById(1));
        System.out.println(server.getCustomerById(2));
    }
}