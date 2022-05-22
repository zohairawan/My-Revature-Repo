/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Factory Design Pattern says you should have a separate class for creating and managing objects
 * This also highlights 'Single Responsibility Principle'
 */

package creational.factory;

public class PaymentService {
    //Instance variable
    private Account account;

    //Constructor
    public PaymentService(String accountType) {
        account = new AccountFactory().manufactureAccount(accountType);
    }

    //Method
    public void pay() {
        System.out.println("Payment using tight coupling -> " + this.account.getDetails());
    }
}
