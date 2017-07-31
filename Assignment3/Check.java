
package assignment3;

/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
public class Check extends Transaction3
{
    private int checkNumber; // check number for each check transaction
 //int number, int id, String type, double amount)
    public Check(int tCount, int tId, String check, double tAmt, int checkNumber) 
    {
        super(tCount, tId, check, tAmt);
        this.checkNumber = checkNumber;
    }
 
    public int getCheckNumber() {
        return checkNumber;
    }
 
    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }
}