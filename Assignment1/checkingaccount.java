package assignment1;
/**
 * Assignment1
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
import java.text.NumberFormat;
import javax.swing.JOptionPane;
 
public class checkingaccount 
{
    private String balStr;
    private double balance,SCbalance;
    public String tSCStr, WarnStr, SCStr;
    public double totalServiceCharge = 0.00;
    public double SC1 = 0;
    public double SC2 = 0;
    public double SC3 = 0;
    public double SC4 = 0;
    public double ServiceCharge1 = 0.10;
    public double ServiceCharge2 = 0.15;
    public double ServiceCharge3 = 5.00; 
    public double ServiceCharge4 = 10.00;
    
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
      public double initialBalance()
      {
        balStr = JOptionPane.showInputDialog ("Enter your account balance: ");
        balance = Double.parseDouble(balStr);  
        SCbalance = balance;
        Assignment1.balance = balance;
        return Assignment1.balance;
      }
      public double getBalance()
      {
        if(Assignment1.tCode == 1)
        {  
        SCbalance = SCbalance - Assignment1.tAmt;
        }
        if(Assignment1.tCode == 2)
        {
        SCbalance = SCbalance + Assignment1.tAmt;
        }
        Assignment1.balance = balance;
        return Assignment1.balance;
      }
 
      public double getServiceCharge()
      {
          SCStr= "";
          if(Assignment1.tCode == 1)
          {
              SCbalance = SCbalance - ServiceCharge2;
              SCStr= SCStr+"Service Charge: Check - "+fmt.format(ServiceCharge2)+"\n";
              SC2++;
              if(SCbalance < 0)
             {  
              SCbalance = SCbalance - ServiceCharge4;
              SCStr= SCStr+"Service Charge: Negative Balance - "+fmt.format(ServiceCharge4)+"\n";
              SC4++;
             }
          }
          if(Assignment1.tCode == 2)
          {
              SCbalance = SCbalance - ServiceCharge1;
              SCStr= SCStr+"Service Charge: Deposit - "+fmt.format(ServiceCharge1)+"\n";
              SC1++;
          }
          if(SC3 == 0)
          {
            if (SCbalance < 500) 
            {
                SCbalance = SCbalance - ServiceCharge3;
                SCStr= SCStr+"Serivce Charge: Below $500 - "+fmt.format(ServiceCharge3)+"\n";
                SC3++;
            }
          }
          totalServiceCharge = (SC1*ServiceCharge1) + (SC2*ServiceCharge2) + (SC3*ServiceCharge3) + (SC4*ServiceCharge4);
          Assignment1.tSC = totalServiceCharge;
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
        Assignment1.Charges = SCStr+WarnStr+tSCStr;
        return Assignment1.Charges;
      }
}
