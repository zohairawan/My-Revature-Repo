/**
 * Program that demonstrates the use of the Factory Design Pattern
 * Factory Design Pattern says you should have a separate class for creating and managing objects
 * This also highlights 'Single Responsibility Principle'
 */

package creational.factory;

public class LoanAccount implements Account{
    //Instance variables
    private String accountNumber;
    private String loanDuration;

    //Constructor
    public LoanAccount(String accountNumber) {
        super();
        this.accountNumber = accountNumber;
    }

    //Getter methods
    public String getAccountNumber() {return accountNumber;}
    public String getLoanDuration() {return  loanDuration;}

    //Setter methods
    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
    public void setLoanDuration(String loanDuration) {this.loanDuration = loanDuration;}

    @Override
    public String getDetails() {
        System.out.println("Loan account getDetails() called");
        return  accountNumber;
    }
}
