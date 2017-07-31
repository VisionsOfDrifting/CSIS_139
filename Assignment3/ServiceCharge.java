
package assignment3;

/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
public class ServiceCharge extends Transaction3
{
    private int associatedTransNumber; // check number for each check transaction
 //int number, int id, String type, double amount)
    public ServiceCharge(int tCount, int tId, String serviceCharge, double tAmt, int associatedTransNumber) 
    {
        super(tCount, tId, serviceCharge, tAmt);
        this.associatedTransNumber = associatedTransNumber;
    }
 
    public int getAssociatedTransNumber() {
        return associatedTransNumber;
    }
 
    public void setAssociatedTransNumber(int associatedTransNumber) {
        this.associatedTransNumber = associatedTransNumber;
    }
}