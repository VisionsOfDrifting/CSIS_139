
package assignment3;
/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
public class Account
{
    protected String name; // The person who owns the account
    protected double accountBalance;// do not define this in CheckingAccount class
 
    public Account(String acctName, double initBalance)
    {
             accountBalance = initBalance;
             name = acctName;
    }
 
    public String getName() 
    {
        return name;
    }
 
    public void setName(String name) 
    {
        this.name = name;
    }
 
    public double getBalance() {
        return accountBalance;
    }
 
    public void setBalance(double accountBalance) 
    {
        this.accountBalance = accountBalance;
    }
}