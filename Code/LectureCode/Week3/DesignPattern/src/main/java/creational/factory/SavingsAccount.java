/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Factory Design Pattern says you should have a separate class for creating and managing objects
 * This also highlights 'Single Responsibility Principle'
 */

package creational.factory;

public class SavingsAccount implements Account{
    //Instance variable
    private String accountNumber;
    private String totalBalance;

    //Constructor
    public SavingsAccount(String accountNumber) {this.accountNumber = accountNumber;}

    @Override
    public String getDetails() {
        System.out.println("Savings Account getDetails() called");
        return accountNumber;
    }

    //Getter methods
    public String getAccountNumber() {return accountNumber;}
    public String getTotalBalance() {return totalBalance;}

    //Setter methods
    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
    public void setTotalBalance(String totalBalance) {this.totalBalance = totalBalance;}
}
