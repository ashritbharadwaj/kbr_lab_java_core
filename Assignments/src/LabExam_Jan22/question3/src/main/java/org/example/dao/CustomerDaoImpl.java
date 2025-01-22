package org.example.dao;

import org.example.dao.dbconnfactory.DBConnFactory;
import org.example.exceptions.DaoException;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    Connection connection = null;

    public CustomerDaoImpl() {
        connection = DBConnFactory.getConnection();
        if(connection!=null) System.out.println("connection established");
    }

    public void addCustomer(Customer customer) {

        String query = "INSERT INTO customers (name, address, phoneNumber) VALUES (?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getPhoneNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) customer.setId(resultSet.getInt(1));
        }catch (SQLException e) {
            throw new DaoException("Error adding customer",e);
        }
    }

    public Customer getCustomerById(int id) {

        String query = "SELECT * FROM customers WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int i = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                return new Customer(i, name, address, phoneNumber);
            }
        }catch (SQLException e) {
            throw new DaoException("Error fetching customer by id",e);
        }
        return null;
    }
}
