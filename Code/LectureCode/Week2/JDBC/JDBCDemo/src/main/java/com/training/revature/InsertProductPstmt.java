/**
 * Program that actually inserts values into database table using a PreparedStatement
 * Once we insert our desired values into the table we want we print how many rows we updated
 */

package com.training.revature;

import java.sql.*;
import java.util.Scanner;

public class InsertProductPstmt {

    public static void main(String[] args) throws SQLException {
        //Creating a Scanner object to take input from user
        Scanner keyboard = new Scanner(System.in);

        //Prompting the user for input
        System.out.print("Please enter the Product ID: ");
        int productId = keyboard.nextInt();

        System.out.print("Please enter the Product name: ");
        String productName = keyboard.next();

        System.out.print("Please enter the Product feedback: ");
        String productFeedback = keyboard.next();

        System.out.print("Please enter the Quantity on hand: ");
        int qoh = keyboard.nextInt();

        System.out.print("Please enter the Price: ");
        int price = keyboard.nextInt();

        System.out.print("Please enter the Product review: ");
        String productReview = keyboard.next();

        //conn object will store the driver and create the connection from DBConnection.getConnection()
        Connection conn = DBConnection.getConnection();

        //3.Create the PreparedStatement
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?,?)");

        //4.Storing the values for a row from the user input
        pstmt.setInt(1, productId);
        pstmt.setString(2, productName);
        pstmt.setString(3, productFeedback);
        pstmt.setInt(4, qoh);
        pstmt.setInt(5, price);
        pstmt.setString(6, productReview);

        //5.Updating the table with stored values from user and storing how many rows were updated
        int rowsUpdated = pstmt.executeUpdate();

        //6.Printing how many rows were updated
        System.out.println(rowsUpdated + " row(s) updated");
        //6.Closing the connection
        pstmt.close();
        conn.close();
    }
}
