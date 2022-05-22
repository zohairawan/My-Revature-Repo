/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Factory Design Pattern says you should have a separate class for creating and managing objects
 * This also highlights 'Single Responsibility Principle'
 */

package creational.factory;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(getAcountType());
        paymentService.pay();
    }

    public static String getAcountType() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the account type (S/C/L) to process the payment");
        String option = keyboard.next();
        keyboard.close();
        return option;
    }
}
