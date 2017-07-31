package assignment3;
/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Assignment3 {

    public static int tCode, checkNum;
    public static double tSC, initialbalance, tAmt, balance, Finbal, currentBal, cashAmt, checkAmt;
    public static String Readout, tType, Charges, balStr, accountName, cashStr, checkStr;
    public static checkingaccount3 c;
    public static JFrame frame;
    
    public static void main (String[] args)
    {
      newAccount();  
      frame = new JFrame ("Account Options");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      EOptionsPanel3 panel = new EOptionsPanel3();
      frame.getContentPane().add (panel);
      frame.pack();
      frame.setVisible(true);
   }
    public static void newTransaction()
   {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
         getTransCode();
         if(tCode == 0)
         {
             getCharges();
             Finbal=balance-tSC;
             Readout = c.getName()+"'s Account-\n"+ 
                "Current Balance: "+fmt.format(balance)+"\n" +
                "Total Service Charges: "+fmt.format(tSC)+ "\n" +
                "Final Balance: "+fmt.format(Finbal);
         JOptionPane.showMessageDialog (null, Readout);
         }
         if(tCode == 1)
         {
            c.getCheckNumber();
            checkNum = c.checkNum;
            getTransAmt();
            processCheck();
         }
         if(tCode == 2)
         {
            getTransAmt();
            processDeposit();
         }
         getCharges();
         Readout = c.getName()+"'s Account-\n"+ 
                   "Transaction Code: "+tCode+"\n"+
                   "Transaction: "+tType+fmt.format(tAmt)+"\n" +
                   "Current Balance: "+fmt.format(balance)+"\n" +
                    Charges;
        JOptionPane.showMessageDialog (null, Readout);
    }
    
   public static void newAccount()
   {
       accountName = JOptionPane.showInputDialog ("Enter the account name: ");
       balStr = JOptionPane.showInputDialog ("Enter your inital balance: ");
       balance = Double.parseDouble(balStr); 
       c = new checkingaccount3(accountName,balance);
   }

   public static int getTransCode()
   {
       String tCodeStr = JOptionPane.showInputDialog ("Enter the transaction code.\n ('1' for check; '2' for deposit; '0' to view balance)");
       tCode = Integer.parseInt(tCodeStr);
       return tCode;
   }
   public static double getTransAmt()
   {
    if(tCode == 1)
    {
       String tAmtStr = JOptionPane.showInputDialog ("Enter your check's ammount: ");
       tAmt = Double.parseDouble(tAmtStr);
    }
    if(tCode == 2)
    {
    JTextField field1 = new JTextField("");
    JTextField field2 = new JTextField("");

    JPanel panel = new JPanel(new GridLayout(0, 1));

    panel.add(new JLabel("Cash Ammount:"));
    panel.add(field1);
    panel.add(new JLabel("Check Ammount:"));
    panel.add(field2);
    field1.addAncestorListener(new SetFocus());
   // field1.requestFocusInWindow();
    int result = JOptionPane.showConfirmDialog(null, panel, "Test",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
           cashStr = field1.getText();
           cashAmt = Double.parseDouble(cashStr);
           checkStr = field2.getText();
           checkAmt = Double.parseDouble(checkStr);
           tAmt = checkAmt + cashAmt;
    } else 
    {
       System.out.println("Cancelled");
       System.exit(0);
        }
    }
       return tAmt;
   }
    
   private static class SetFocus implements AncestorListener 
  {
    public void ancestorAdded(AncestorEvent e) {
    JComponent component = e.getComponent();
    component.requestFocusInWindow();
    }

    public void ancestorMoved(AncestorEvent e) {
    }

    public void ancestorRemoved(AncestorEvent e) {
    }
   }
   
   public static double processCheck()
   {
       c.getBalance();
       tType= "Check #" +checkNum+ " in amount of: ";
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