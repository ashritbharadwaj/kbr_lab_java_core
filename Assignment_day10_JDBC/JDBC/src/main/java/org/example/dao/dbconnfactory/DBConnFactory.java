package org.example.dao.dbconnfactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnFactory {
    public static Connection getConnection(){
        Connection connection = null;

        InputStream in = DBConnFactory.class.getClassLoader().getResourceAsStream("dbconn.properties");

        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String driver = properties.getProperty("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        try{
            Class.forName(driver);
            connection = java.sql.DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
