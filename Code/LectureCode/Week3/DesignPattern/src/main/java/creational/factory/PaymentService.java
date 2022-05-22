/**
 * Program that demonstrates the use of the Factory Design Pattern
 */

package creational.factory;

public class PaymentService {
    //Instance variable
    private Account account;

    //Constructor
    public PaymentService(String accountType) {
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
    }

    //Method
    public void pay() {
        System.out.println("Payment using tight coupling -> " + this.account.getDetails());
    }
}
