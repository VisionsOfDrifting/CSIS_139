
package assignment3;

/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
public class Deposit extends Transaction3 
{
    private double checkAmt, cashAmt; 
    public Deposit(int tCount, int tId, String deposit, double tAmt, double checkAmt, double cashAmt) 
    {
        super(tCount, tId, deposit, tAmt);
        this.checkAmt = checkAmt;
        this.cashAmt = cashAmt;
    }
 
    public double getCheckAmmount() 
    {
        return checkAmt;
    }
 
    public void setCheckAmmount(double checkAmt) 
    {
        this.checkAmt = checkAmt;
    }
    
     public double getCashAmmount() 
    {
        return cashAmt;
    }
 
    public void setCashAmmount(double cashAmt) 
    {
        this.cashAmt = cashAmt;
    }
}