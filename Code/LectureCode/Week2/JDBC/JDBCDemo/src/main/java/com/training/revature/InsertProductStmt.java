/**
 * Program that actually inserts values into database table using a Statement
 * Once we insert our desired values into the table we want we print how many rows we updated
 */

package com.training.revature;

import java.sql.*;

public class InsertProductStmt {

    public static void main(String[] args) throws SQLException {
        //conn object will store the driver and create the connection from DBConnection.getConnection()
        Connection conn = DBConnection.getConnection();

        //3.Create the statement
        Statement stmt = conn.createStatement();

        //4.Updating the database table and storing the return data
        int rowsUpdated = stmt.executeUpdate("INSERT INTO product VALUES(4, 'Mouse', 'Average', 15, 35, default)");

        //5.Printing the return data
        System.out.println(rowsUpdated + " row(s) updated");
        //6.Closing the connection
        stmt.close();
        conn.close();
    }
}
