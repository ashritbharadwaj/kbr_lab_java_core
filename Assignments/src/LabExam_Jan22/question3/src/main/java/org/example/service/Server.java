package org.example.service;

import org.example.dao.Customer;
import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.exceptions.DaoException;

public class Server {
    CustomerDao customerDao = new CustomerDaoImpl();

    public void addCustomer(Customer customer) throws DaoException {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int id) throws DaoException {
        return customerDao.getCustomerById(id);
    }
}

