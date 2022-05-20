/**
 * Program that actually inserts values into database table using a Statement
 * Once we insert our desired values into the table we want we print how many rows we updated
 */

package com.training.revature;

import java.sql.*;

public class InsertProductStmt {

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

            //4.Updating the database table and storing the return data
            int rowsUpdated = stmt.executeUpdate("INSERT INTO product VALUES(4, 'Mouse', 'Average', 15, 35, default)");

            //5.Printing the return data
            System.out.println(rowsUpdated + " row(s) updated");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not available");
        } catch (SQLException e) {
            System.out.println("Connection to database unsuccessful");
        } finally {
            //6.Closing the connection
            stmt.close();
            conn.close();
        }


    }
}
