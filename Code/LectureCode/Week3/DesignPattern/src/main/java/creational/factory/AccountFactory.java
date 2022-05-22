/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Factory Design Pattern says you should have a separate class for creating and managing objects
 * This also highlights 'Single Responsibility Principle'
 */

package creational.factory;

public class AccountFactory {
    //Method
    public Account manufactureAccount(String accountType) {
        Account account = null;
        if(accountType.equalsIgnoreCase("S")) {
            account = new SavingsAccount("S123");
        }
        else if(accountType.equalsIgnoreCase("C")) {
            account = new CurrentAccount("C123");
        }
        else if(accountType.equalsIgnoreCase("L")) {
            account = new LoanAccount("L123");
        }
        else {
            System.out.println("Invalid input");
        }
        return account;
    }
}
