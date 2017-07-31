package Assignment5;
/**
 * Assignment5
 * Nicholas Pappas
 * CS/IS 139
 */
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Assignment5 {

    public static int tCode, checkNum;
    public static double tSC, initialbalance, tAmt, balance, Finbal, currentBal, cashAmt, checkAmt;
    public static String Readout, tType, Charges, balStr, accountName, cashStr, checkStr, filename = "C:\\ChecckingAccount.dat";
    public static CheckingAccount5 c;
    public static Vector<CheckingAccount5> dataStore;
    public static EOptionsFrame frame;
    public static JTextArea ta;
    public static boolean saved=true;
    
    public static void main (String[] args)
    {
      dataStore = new Vector<CheckingAccount5>();
      newAccount();  
      frame = new EOptionsFrame ("Account Options");
      ta = new JTextArea(10,50);
      ta.setFont(new Font("Monospaced",Font.PLAIN, 12));
      frame.getContentPane().add (ta);
      frame.pack();
      frame.setVisible(true);
   }
    
    public static void newTransaction()
   {
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
        getTransCode();
        if(tCode == 0)
        {
            c.setServiceCharge();
            Finbal=balance-c.getServiceCharge();
            Readout = c.getName()+"'s Account-\n"+ 
                "Current Balance: "+fmt.format(balance)+"\n" +
                "Total Service Charges: "+fmt.format(c.getServiceCharge())+ "\n" +
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
        c.getServiceCharge();
        Readout = c.getName()+"'s Account-\n"+ 
                   "Transaction Code: "+tCode+"\n"+
                   "Transaction: "+tType+fmt.format(tAmt)+"\n" +
                   "Current Balance: "+fmt.format(c.getBalance())+"\n" +
                    c.getSCStr();
        JOptionPane.showMessageDialog (null, Readout);
		saved=false;
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
    int result = JOptionPane.showConfirmDialog(null, panel, "Deposit",
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
   
   public static void processCheck()
   {
       c.setBalance(tAmt, tCode);
       c.setServiceCharge();
       tType= "Check #" +checkNum+ " in amount of: ";
   }
   public static void processDeposit()
   {
       c.setBalance(tAmt, tCode);
       c.setServiceCharge();
       tType= "Deposit in amount of: ";
   }

   public static void readCheckingAccount() 
   {  
	int confirm;  
        if (!saved)
        {
           String  message = "The data in the account is not saved.\n"+
               "Would you like to save your account before loading another?";
           confirm = JOptionPane.showConfirmDialog (null, message);
           if (confirm == JOptionPane.YES_OPTION)
           chooseFile(2); 
        }
        chooseFile(1);	
	try
	{
            FileInputStream fis = new
            FileInputStream(filename);
            ObjectInputStream in = new
            ObjectInputStream(fis);       
            dataStore = (Vector<CheckingAccount5>)in.readObject();
            in.close();
            int index = dataStore.size();
            c = dataStore.elementAt(index);
            saved=true;
	}	
	catch(ClassNotFoundException e)	
        { 
            System.out.println(e);
        }
        catch (IOException e) 
        { 
            System.out.println(e);
        }
   }
   
   public static void writeCheckingAccount() 
   {  
		dataStore.addElement(c);
		chooseFile(2);
      	try
	{
            FileOutputStream fos = new
            FileOutputStream(filename);
            ObjectOutputStream out = new
            ObjectOutputStream(fos);
            out.writeObject(dataStore);
            out.close();
            saved = true;
	}	
	catch(IOException e)	
        { 
            System.out.println(e);
	} 
   }
   
   public static void chooseFile(int ioOption) 
   {  
    int status, confirm;       
    String  message = "Would you like to use the current default file: \n" + filename;
    confirm = JOptionPane.showConfirmDialog (null, message);
    if (confirm == JOptionPane.YES_OPTION)
    { 
        return;}
    JFileChooser chooser = new JFileChooser();
    if (ioOption == 1)
    {
		status = chooser.showOpenDialog (null);}
    else if (ioOption == 2)
    {
		  status = chooser.showSaveDialog (null);
      if (status == JFileChooser.APPROVE_OPTION)
      {
          File file = chooser.getSelectedFile();
          filename = file.getPath();}
	}
   }
   
   public static void newAccount()
   {
	if(!saved)
	{
	   dataStore.addElement(c);
	}
       accountName = JOptionPane.showInputDialog ("Enter the account name: ");
       balStr = JOptionPane.showInputDialog ("Enter your inital balance: ");
       balance = Double.parseDouble(balStr); 
       c = new CheckingAccount5(accountName,balance);
       saved = false;
   }
   
   public static void findAccount()
   {  
    String name;
    name = JOptionPane.showInputDialog ("Enter the name of the Account holder : ");
	for (int index=0; index != dataStore.size(); index++)
	{
	  c = dataStore.elementAt(index);
	  if (name.equals(c.getName()))
		{
			String message = "Found account for " + name;
			ta.setText(message);
		}
	}
   }
}