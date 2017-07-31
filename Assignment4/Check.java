package assignment4;
/**
 * Assignment4
 * Nicholas Pappas
 * CS/IS 139
 */
public class Check extends Transaction
{
    private int checkNumber; 
	
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