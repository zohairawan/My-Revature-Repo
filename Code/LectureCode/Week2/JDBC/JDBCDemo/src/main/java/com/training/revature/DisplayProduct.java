/**
 * Program that actually communicates with PostgreSQL database
 * We pull information from the database and then display it
 */

package com.training.revature;

import java.sql.*;

public class DisplayProduct {
    public static void main(String[] args) throws SQLException {
        //conn object will store the driver and create the connection from DBConnection.getConnection()
        Connection conn = DBConnection.getConnection();

        //3.Create the statement
        Statement stmt = conn.createStatement();

        //4.Execute the query and store the results
        ResultSet result = stmt.executeQuery("SELECT * from product");

        //5.Looping through the results and printing them out
        while (result.next()) {
            System.out.print(result.getInt(1) + " ");
            System.out.print(result.getString(2) + " ");
            System.out.print(result.getString(3) + " ");
            System.out.print(result.getInt(4) + " ");
            System.out.print(result.getInt(5) + " ");
            System.out.print(result.getString(6) + " ");
            System.out.println();
        }

        //6.Closing the connection
        stmt.close();
        conn.close();

    }
}
