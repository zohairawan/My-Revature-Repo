package com.training.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //This method reduces redundancy in all classes that want to load a driver and create a connection w/ database
    public static Connection getConnection() {
        //Local variable
        Connection conn = null;
        try {
            //1.Load the Driver for our specific database
            Class.forName("org.postgresql.Driver");

            //2.Create a connection to the database
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Return the connection
        return conn;
    }
}
