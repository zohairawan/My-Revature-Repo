/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Factory Design Pattern says you should have a separate class for creating and managing objects
 * This also highlights 'Single Responsibility Principle'
 */

package creational.factory;

public class CurrentAccount implements Account{
    //Instance variable
    private String accountNumber;
    private String dailyLimit;

    //Constructor
    public CurrentAccount(String accountNumber) {
        super();
        this.accountNumber = accountNumber;
    }

    //Getter Method
    public String getAccountNumber() {return accountNumber;}

    //Method
    @Override
    public String getDetails() {
        System.out.println("Current account getDetails() called");
        return accountNumber;
    }
}
