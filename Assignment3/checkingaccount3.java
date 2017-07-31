
package assignment3;
/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class checkingaccount3 extends Account
{
    private double balance, SCbalance;
    public String tSCStr, WarnStr, SCStr, transType;
    private double totalServiceCharge = 0.00;
    public int SC1 = 0; public int SC2 = 0; public int SC3 = 0; public int SC4 = 0; public int transNum = 0;
    public double ServiceCharge1 = 0.10; public double ServiceCharge2 = 0.15;
    public double ServiceCharge3 = 5.00; public double ServiceCharge4 = 10.00;
    public int tCode2, list, checkNum, aTransNum;
    public double transAmt;
    protected TransList3 account1 = new TransList3();
    
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    public checkingaccount3(String acctName, double initalBalance) 
    {
        super(acctName, initalBalance);
        SCbalance = initalBalance;
        balance = initalBalance;
    }
    
    public double getBalance()
      {
        if(Assignment3.tCode == 1)
        {  
        balance = balance - Assignment3.tAmt;
        tCode2 = 1;
        transType = "Check";
        account1.addTransaction (transNum , tCode2 , transType, Assignment3.tAmt);
        }
        if(Assignment3.tCode == 2)
        {
        balance = balance + Assignment3.tAmt;
        tCode2 = 2;
        transType = "Deposit";
        account1.addTransaction (transNum , tCode2 , transType, Assignment3.tAmt);
        }
        transNum++;
        Assignment3.balance = balance;
        return Assignment3.balance;
      }
  
    public int getCheckNumber()
   {
       String checkNumStr = JOptionPane.showInputDialog ("Enter your check number: ");
       checkNum = Integer.parseInt(checkNumStr);
       return checkNum;
   }
    
      public double getServiceCharge()
      {
          aTransNum = transNum-1;
          SCStr= "";
          if(Assignment3.tCode == 1)
          {
              SCbalance = SCbalance - ServiceCharge2;
              SCStr= SCStr+"Service Charge: Check - "+fmt.format(ServiceCharge2)+"\n";
              SC2++;
              tCode2 = 3;
              transType = "Svc. Chrg.";
              account1.addTransaction (transNum , tCode2 , transType, ServiceCharge2);
              transNum++;
              if(balance < 0)
             {  
              SCbalance = SCbalance - ServiceCharge4;
              SCStr= SCStr+"Service Charge: Negative Balance - "+fmt.format(ServiceCharge4)+"\n";
              SC4++;
              tCode2 = 3;
              transType = "Svc. Chrg.";
              account1.addTransaction (transNum , tCode2 , transType, ServiceCharge4);
              transNum++;
             }
          }
          if(Assignment3.tCode == 2)
          {
              SCbalance = SCbalance - ServiceCharge1;
              SCStr= SCStr+"Service Charge: Deposit - "+fmt.format(ServiceCharge1)+"\n";
              SC1++;
              tCode2 = 3;
              transType = "Svc. Chrg.";
              account1.addTransaction (transNum , tCode2 , transType, ServiceCharge1);
              transNum++;
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
                account1.addTransaction (transNum , tCode2 , transType, ServiceCharge3);
                transNum++;
            }
          }
          totalServiceCharge = (SC1*ServiceCharge1) + (SC2*ServiceCharge2) + (SC3*ServiceCharge3) + (SC4*ServiceCharge4);
          Assignment3.tSC = totalServiceCharge;
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
        Assignment3.Charges = SCStr+WarnStr+tSCStr;
        return Assignment3.Charges;
      }
        
       public void GenerateList()
        {
            if(EOptionsPanel3.List == 1)
            {
                account1.listTransactions();
            }
            if(EOptionsPanel3.List == 2)
            {
                account1.listChecks();
            }
            if(EOptionsPanel3.List == 3)
            {
                account1.listDeposits();
            }
             if(EOptionsPanel3.List == 4)
            {
                account1.listServiceCharges();
            }
        }
}