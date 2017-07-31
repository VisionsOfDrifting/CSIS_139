package assignment1;

import java.text.NumberFormat;
import javax.swing.JOptionPane;
/**
 * Assignment1
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
public class Assignment1 
{  
    public static int tCode;
    public static double tSC, initialbalance, tAmt, balance, Finbal, currentBal;
    public static String Readout, tType, Charges;
    public static checkingaccount c = new checkingaccount();
    public static void main (String[] args)
    {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       c.initialBalance();
       do
       {
         getTransCode();
         if(tCode != 0)
         {
            getTransAmt();
            if(tCode == 1)
            {
                processCheck();
            }
            if(tCode == 2)
            {
                processDeposit();
            }
            getCharges();
            Readout = "Transaction Code: "+tCode+"\n"+
                      "Transaction: "+tType+fmt.format(tAmt)+"\n" +
                      "Current Balance: "+fmt.format(balance)+"\n" +
                      Charges;
            JOptionPane.showMessageDialog (null, Readout);
         }
      }
      while (tCode!=0);
      getCharges();
      Finbal=balance-tSC;
      Readout = "Transaction: END"+"\n" +
                "Current Balance: "+fmt.format(balance)+"\n" +
                "Total Service Charges: "+fmt.format(tSC)+ "\n" +
                "Final Balance: "+fmt.format(Finbal);
      JOptionPane.showMessageDialog (null, Readout);
   }
   public static int getTransCode()
   {
       String tCodeStr = JOptionPane.showInputDialog ("Enter your transaction code: ");
       tCode = Integer.parseInt(tCodeStr);
       return tCode;
   }
   public static double getTransAmt()
   {
       String tAmtStr = JOptionPane.showInputDialog ("Enter your transaction ammount: ");
       tAmt = Double.parseDouble(tAmtStr);
       return tAmt;
   }
   public static double processCheck()
   {
       c.getBalance();
       tType= "Check in amount of: ";
       return balance;
   }
   public static double processDeposit()
   {
       c.getBalance();
       tType= "Deposit in amount of: ";
       return balance;
   }
   public static String getCharges()
   {
        c.getServiceCharge();
        c.setSCStr();
        return Charges;
   }
}
