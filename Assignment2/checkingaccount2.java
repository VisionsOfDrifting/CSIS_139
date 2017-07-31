
package assignment2;
/**
 * Assignment1
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class checkingaccount2 
{
    private String balStr;
    private double balance,SCbalance;
    public String tSCStr, WarnStr, SCStr, transType;
    public double totalServiceCharge = 0.00;
    public int SC1 = 0;
    public int SC2 = 0;
    public int SC3 = 0;
    public int SC4 = 0;
    public double ServiceCharge1 = 0.10;
    public double ServiceCharge2 = 0.15;
    public double ServiceCharge3 = 5.00; 
    public double ServiceCharge4 = 10.00;
    public int tCode2, list;
    public int transNum = 0;
    public double transAmt;
    public static TransList account1 = new TransList ();
    
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
      public double initialBalance()
      {
        balStr = JOptionPane.showInputDialog ("Enter your account balance: ");
        balance = Double.parseDouble(balStr);  
        SCbalance = balance;
        Assignment2.balance = balance;
        return Assignment2.balance;
      }
      public double getBalance()
      {
        if(Assignment2.tCode == 1)
        {  
        balance = balance - Assignment2.tAmt;
        tCode2 = 1;
        transType = "Check";
        }
        if(Assignment2.tCode == 2)
        {
        tCode2 = Assignment2.tCode;
        balance = balance + Assignment2.tAmt;
        tCode2 = 2;
        transType = "Deposit";
        }
        transNum++;
        account1.addTransaction (transNum , tCode2 , transType, Assignment2.tAmt);
        Assignment2.balance = balance;
        return Assignment2.balance;
      }
 
      public double getServiceCharge()
      {
          SCStr= "";
          if(Assignment2.tCode == 1)
          {
              SCbalance = SCbalance - ServiceCharge2;
              SCStr= SCStr+"Service Charge: Check - "+fmt.format(ServiceCharge2)+"\n";
              SC2++;
              tCode2 = 3;
              transType = "Svc. Chrg.";
              transNum++;
              account1.addTransaction (transNum , tCode2 , transType, ServiceCharge2);
              if(balance < 0)
             {  
              SCbalance = SCbalance - ServiceCharge4;
              SCStr= SCStr+"Service Charge: Negative Balance - "+fmt.format(ServiceCharge4)+"\n";
              SC4++;
              tCode2 = 3;
              transType = "Svc. Chrg.";
              transNum++;
              account1.addTransaction (transNum , tCode2 , transType, ServiceCharge4);
             }
          }
          if(Assignment2.tCode == 2)
          {
              SCbalance = SCbalance - ServiceCharge1;
              SCStr= SCStr+"Service Charge: Deposit - "+fmt.format(ServiceCharge1)+"\n";
              SC1++;
              tCode2 = 3;
              transType = "Svc. Chrg.";
              transNum++;
              account1.addTransaction (transNum , tCode2 , transType, ServiceCharge1);
          }
          if(SC3 == 0)
          {
            if (balance < 500) 
            {
                SCbalance = SCbalance - ServiceCharge3;
                SCStr= SCStr+"Serivce Charge: Below $500 - "+fmt.format(ServiceCharge3)+"\n";
                SC3++;
                tCode2 = 3;
                transType = "Svc. Chrg.";
                transNum++;
                account1.addTransaction (transNum , tCode2 , transType, ServiceCharge3);
            }
          }
          totalServiceCharge = (SC1*ServiceCharge1) + (SC2*ServiceCharge2) + (SC3*ServiceCharge3) + (SC4*ServiceCharge4);
          Assignment2.tSC = totalServiceCharge;
          return totalServiceCharge;
      }
 
        public String setSCStr()
      {
        if(balance < 50)
        {
            WarnStr= "Warning: Balance below $50.00"+"\n";
        }
        else
          {
               WarnStr= "";
          }
        tSCStr= "Total Service Charge: "+fmt.format(totalServiceCharge)+"\n";
        Assignment2.Charges = SCStr+WarnStr+tSCStr;
        return Assignment2.Charges;
      }
       public static void GenerateList()
        {
            if(EOptionsPanel.List == 1)
            {
                account1.listTransactions();
            }
            if(EOptionsPanel.List == 2)
            {
                account1.listChecks();
            }
            if(EOptionsPanel.List == 3)
            {
                account1.listDeposits();
            }
        }
}