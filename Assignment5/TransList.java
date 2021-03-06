package Assignment5;
/**
 * Assignment5
 * Nicholas Pappas
 * CS/IS 139
 */
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TransList
{
   private Transaction[] Translist;
   private int count, checkNumber, associatedTransNumber;
   private double checkAmt, cashAmt;
   NumberFormat fmt = NumberFormat.getCurrencyInstance();

   public TransList()
   {
      Translist = new Transaction[10];
      count = 0;
   }

   public void addTransaction (int transNumber, int transId, String transType, double transAmt)
   {
      if (count == Translist.length)
      {
          increaseSize();
      }
      if (transId == 1)
      {
       checkNumber = Assignment5.c.checkNum;
       Translist[count] = new Check (transNumber, transId, transType, transAmt, checkNumber);   
      }
      if (transId == 2)
      {
       checkAmt = Assignment5.checkAmt;
       cashAmt = Assignment5.cashAmt;
       Translist[count] = new Deposit (transNumber, transId, transType, transAmt, checkAmt, cashAmt);   
      }
      if (transId == 3)
      {
       associatedTransNumber = Assignment5.c.aTransNum;
       Translist[count] = new ServiceCharge (transNumber, transId, transType, transAmt, associatedTransNumber);   
      }
      count++;
   }

   private void increaseSize ()
   {
      Transaction[] temp = new Transaction[Translist.length * 2];

      for (int t = 0; t < Translist.length; t++)
      {
          temp[t] = Translist[t];
      }
      Translist = temp;
   }  
   
       public void listTransactions()
   {  
      String message;
      int num;
      message =  "Name: "+Assignment5.c.getName()+"\nBalance: "+Assignment5.c.getBalance()+
	  "\nTotal Service Charge: "+Assignment5.c.getServiceCharge()+"\n\nList of all transactions:"+"\n\n";
      message += String.format("%-3s    %-10s        %6s\n","Transaction #","Type", "Ammount");
      for ( num=0; num < count; num++)
      {  
         message += String.format("%-3d              %-10s        %7s\n",
         Translist[num].getTransNumber(),Translist[num].getTransType(), fmt.format(Translist[num].getTransAmount()));
      }
      //ta.setText(message);
    }
       
        public void listChecks()
   {  
      String message;
      int num;
      message = "List of all Checks for "+Assignment5.c.getName()+":\n\n";
      message+= String.format("%-3s    %-10s     %6s","Transaction #","Check","Ammount\n");
      for ( num=0; num < count; num++)
      {  
         if (Translist[num].getTransId() == 1)
         {
             message += String.format("%-3d              %-10s     %7s\n",
             Translist[num].getTransNumber(), ((Check)Translist[num]).getCheckNumber(), 
             fmt.format(Translist[num].getTransAmount()));
         }
      }
      //ta.setText(message);
    }
        
         public void listDeposits()
   {  
      String message;
      int num;
      message = "List of all Deposits for "+Assignment5.c.getName()+":\n\n";
      message+= String.format("%-3s    %-10s   %-7s      %6s     %6s\n","Transaction #","Type","Checks","Cash","Ammount");
      for ( num=0; num < count; num++)
      {  
         if (Translist[num].getTransId() == 2)
         {
             message += String.format("%-3s              %-10s  %-7s      %7s     %7s\n",
             Translist[num].getTransNumber(),Translist[num].getTransType(), fmt.format(((Deposit)Translist[num]).getCheckAmmount()), 
             fmt.format(((Deposit)Translist[num]).getCashAmmount()), fmt.format(Translist[num].getTransAmount()));
         }
      }
      //ta.setText(message);
    }
         
           public void listServiceCharges()
   {  
      String message;
      int num;
      message = "List of all Service Charges for "+Assignment5.c.getName()+":\n\n";
      message+= String.format("%-3s    %-10s     %6s","Transaction #","Associated TransNumber","Ammount\n");
      for ( num=0; num < count; num++)
      {  
         if (Translist[num].getTransId() == 3)
         {
             message += String.format("%-3d                       %-10s        %7s\n",
             Translist[num].getTransNumber(),  ((ServiceCharge)Translist[num]).getAssociatedTransNumber(), 
             fmt.format(Translist[num].getTransAmount()));
         }
      }
      //ta.setText(message);
    }    
}