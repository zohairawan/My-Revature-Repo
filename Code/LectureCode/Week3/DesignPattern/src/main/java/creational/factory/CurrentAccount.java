/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Account interface allows us to add new accounts easier
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
