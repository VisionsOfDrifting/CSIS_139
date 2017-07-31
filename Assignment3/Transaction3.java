
package assignment3;

/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
public class Transaction3
{
  
    public int transNumber;
    public int transId;
    public String transType;
    public double transAmount;
    
    public Transaction3(int number, int id, String type, double amount)
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
 