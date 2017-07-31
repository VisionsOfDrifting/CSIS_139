package assignment4;

import java.io.Serializable;

/**
 * Assignment4
 * Nicholas Pappas
 * CS/IS 139
 */
public class Account implements Serializable
{
    protected String name;
    protected double accountBalance;
 
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