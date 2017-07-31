package assignment2;
/**
 * Assignment1
 * Checking Account
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
   private int count;
   NumberFormat fmt = NumberFormat.getCurrencyInstance();

   public TransList ()
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
      
      Translist[count] = new Transaction (transNumber, transId, transType, transAmt);
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
      JTextArea text = new JTextArea();
      String message = "";
      int num;
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message += "List of All Transactions\n\n";
      message += String.format("%-3s    %-10s          %6s\n","Transaction #","Type", "Ammount");
      for ( num=0; num < count; num++)
      {  
         message += String.format("%-3d              %-10s          %7s\n",
                 Translist[num].getTransNumber(),Translist[num].getTransType(), fmt.format(Translist[num].getTransAmount()));
      }
      text.setText(message);
      JOptionPane.showMessageDialog(null, text);
    }
       
        public void listChecks()
   {  
      JTextArea text = new JTextArea();
      String message = "";
      int num;
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message += "List of All Checks\n\n";
      message+= String.format("%-3s     %6s","Transaction #","Ammount\n");
      for ( num=0; num < count; num++)
      {  
         if (Translist[num].getTransId() == 1)
         {
             message += String.format("%-3d               %7s\n",
                 Translist[num].getTransNumber(), fmt.format(Translist[num].getTransAmount()));
         }
      }
      text.setText(message);
      JOptionPane.showMessageDialog(null, text);
    }
        
         public void listDeposits()
   {  
      JTextArea text = new JTextArea();
      String message = "";
      int num;
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message += "List of All Deposits\n\n";
      message+= String.format("%-3s     %6s","Transaction #","Ammount\n");
      for ( num=0; num < count; num++)
      {  
         if (Translist[num].getTransId() == 2)
         {
             message += String.format("%-3d               %7s\n",
                 Translist[num].getTransNumber(), fmt.format(Translist[num].getTransAmount()));
         }
      }
      text.setText(message);
      JOptionPane.showMessageDialog(null, text);
    }
}