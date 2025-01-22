package org.example.dao;

import java.util.List;

public interface CustomerDao {
    Customer getCustomerById(int id);
    //List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
}
