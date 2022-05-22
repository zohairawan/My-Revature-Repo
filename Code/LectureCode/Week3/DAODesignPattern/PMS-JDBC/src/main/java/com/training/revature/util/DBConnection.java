package com.training.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    //This method reduces redundancy in all classes that want to load a driver and create a connection w/ database
    public static Connection getConnection() {
        //Local variable
        Connection conn = null;
        try {
            //1.Retrieve the file containing the Driver and connection information and store it in reader
            FileReader reader = new FileReader("C:\\Users\\Zohair\\IdeaProjects\\Revature\\Code\\LectureCode\\Week2\\JDBC\\DBConnection.properties");

            //2.Properties object will be used to store the key/value pairs of the reader file(DBConnection.properties)
            Properties properties = new Properties();
            properties.load(reader);

            //3.Load the Driver for our specific database by using the property object instead of hardcoding
            Class.forName(properties.getProperty("driver"));

            //4.Create a connection to the database by using properties object to get key(url,user,password)
            conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Return the connection
        return conn;
    }
}
