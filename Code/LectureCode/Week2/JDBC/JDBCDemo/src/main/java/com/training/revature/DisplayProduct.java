/**
 * Program that actually communicates with PostgreSQL database
 * We pull information from the database and then display it
 */

package com.training.revature;

import java.sql.*;

public class DisplayProduct {

    public static void main(String[] args) throws SQLException {
        //Instance variable(s)
        Connection conn = null;
        Statement stmt = null;

        try {
            //1.Load the Driver for our specific database
            Class.forName("org.postgresql.Driver");

            //2.Create a connection to the database
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

            //3.Create the statement
            stmt = conn.createStatement();

            //4.Execute the query and store the results
            ResultSet result = stmt.executeQuery("SELECT * from product");

            //5.Looping through the results and printing them out
            while(result.next()) {
                System.out.print(result.getInt(1) + " ");
                System.out.print(result.getString(2) + " ");
                System.out.print(result.getString(3) + " ");
                System.out.print(result.getInt(4) + " ");
                System.out.print(result.getInt(5) + " ");
                System.out.print(result.getString(6) + " ");
                System.out.println();
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver not available");
        }
        catch (SQLException e) {
            System.out.println("Connection to database unsuccessful");
        }
        finally {
            //6.Closing the connection
            stmt.close();
            conn.close();
        }
    }
}
