package assignment4;
/**
 * Assignment4
 * Nicholas Pappas
 * CS/IS 139
 */
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class CheckingAccount4 extends Account
{
 
    private double balance, totalServiceCharge = 0.00;
    public String Charges, tSCStr, WarnStr, SCStr, transType;
    public int tCode2, list, checkNum, aTransNum, tCode;
    public int SC1 = 0, SC2 = 0, SC3 = 0, SC4 = 0, transNum = 0;
    public double ServiceCharge1 = 0.10, ServiceCharge2 = 0.15, ServiceCharge3 = 5.00, ServiceCharge4 = 10.00;
    protected TransList account1 = new TransList();
    
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
 
    public CheckingAccount4(String accountName, double initialBalance) 
	{
        super(accountName, initialBalance);
        balance = initialBalance;
    }
 
    public double getBalance()
    {
        return balance;
    }
 
    public void setBalance(double tAmt, int tCodeMain)
    {
        tCode = tCodeMain;
        if(tCode == 1)
        {
			balance = balance - tAmt;
			tCode2 = 1;
			transType = "Check";
			account1.addTransaction (transNum , tCode2 , transType, tAmt);
		}
        else if(tCode == 2)
		{
            balance = balance + tAmt;
			tCode2 = 2;
			transType = "Deposit";
			account1.addTransaction (transNum , tCode2 , transType, tAmt);
		}
		transNum++;
    }
   
    public int getCheckNumber()
    {
	String checkNumStr = JOptionPane.showInputDialog ("Enter your check number: ");
	checkNum = Integer.parseInt(checkNumStr);
	return checkNum;
    }
 
    public double getServiceCharge()
    {
        return totalServiceCharge;
    }
 
    public void setServiceCharge()
    {
        aTransNum = transNum-1;
        SCStr= "";
	tCode2 = 3;
        if(tCode == 1)
        {
            SCStr= SCStr+"Service Charge: Check - "+fmt.format(ServiceCharge2)+"\n";
            SC2++;
            transType = "Svc. Chrg.";
            account1.addTransaction (transNum , tCode2 , transType, ServiceCharge2);
            transNum++;
            if(balance < 0)
            {  
				SCStr= SCStr+"Service Charge: Negative Balance - "+fmt.format(ServiceCharge4)+"\n";
				SC4++;
				transType = "Svc. Chrg.";
				account1.addTransaction (transNum , tCode2 , transType, ServiceCharge4);
				transNum++;
            }
        }
        if(tCode == 2)
        {
            SCStr= SCStr+"Service Charge: Deposit - "+fmt.format(ServiceCharge1)+"\n";
            SC1++;
            transType = "Svc. Chrg.";
            account1.addTransaction (transNum , tCode2 , transType, ServiceCharge1);
            transNum++;
        }
        if(SC3 == 0)
        {
            if (balance < 500) 
            {
                SCStr= SCStr+"Serivce Charge: Below $500 - "+fmt.format(ServiceCharge3)+"\n";
                SC3++;
                transType = "Svc. Chrg.";
                account1.addTransaction (transNum , tCode2 , transType, ServiceCharge3);
                transNum++;
            }
        }
        totalServiceCharge = (SC1*ServiceCharge1) + (SC2*ServiceCharge2) + (SC3*ServiceCharge3) + (SC4*ServiceCharge4);
    }
    
    public String getSCStr()
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
        Charges = SCStr+WarnStr+tSCStr;
        return Charges;
    }
        
    public void GenerateList()
    {
        if(EOptionsPanel4.List == 1)
        {
            account1.listTransactions();
        }
        if(EOptionsPanel4.List == 2)
        {
            account1.listChecks();
        }
        if(EOptionsPanel4.List == 3)
        {
            account1.listDeposits();
        }
        if(EOptionsPanel4.List == 4)
        {
            account1.listServiceCharges();
        }
    }
}