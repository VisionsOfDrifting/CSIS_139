package assignment4;

import java.io.Serializable;

/**
 * Assignment4
 * Nicholas Pappas
 * CS/IS 139
 */
public class Transaction implements Serializable
{
  
    public int transNumber;
    public int transId;
    public String transType;
    public double transAmount;
    
    public Transaction(int number, int id, String type, double amount)
    {
        transNumber = number;
        transId = id;
        transType = type;
        transAmount = amount;
    }
   
    public int getTransNumber()
    {
        return transNumber;
    }
   
    public int getTransId()
    {
        return transId;
    }
    
    public String getTransType()
    {
        return transType;
    }
   
    public double getTransAmount()
    {
        return transAmount;
    }
}
 