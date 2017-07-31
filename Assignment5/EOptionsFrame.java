package Assignment5;
/**
 * Assignment5
 * Nicholas Pappas
 * CS/IS 139
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class EOptionsFrame extends JFrameL
{
    public int List;
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    private JMenu fileMenu, acctMenu, transMenu;
    private JMenuItem newTrans,writeFile,readFile,listTrans,
	listChecks,listDeposits,listSC,findAcct;
    private JMenuBar bar;
    
    public EOptionsFrame(String title )
    {
        super(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        fileMenu = new JMenu("File");
        acctMenu = new JMenu("Account");
		transMenu = new JMenu("Transactions");
		
        MenuListener ml = new MenuListener();     

        newTrans = new JMenuItem("New Transaction");
        newTrans.addActionListener(ml);
        transMenu.add(newTrans);

        writeFile = new JMenuItem("Write Account");
        writeFile.addActionListener(ml);
        fileMenu.add(writeFile);
		
		readFile = new JMenuItem("Read Account");
        readFile.addActionListener(ml);
        fileMenu.add(readFile);
        
        listTrans = new JMenuItem("List all Transactions");
        listTrans.addActionListener(ml);
        acctMenu.add(listTrans);

        listChecks = new JMenuItem("List all Checks");
        listChecks.addActionListener(ml);
        acctMenu.add(listChecks);
		
		listDeposits = new JMenuItem("List Deposits");
        listDeposits.addActionListener(ml);
        acctMenu.add(listDeposits);
		
		listSC = new JMenuItem("List all Service Charges");
        listSC.addActionListener(ml);
        acctMenu.add(listSC);

        findAcct = new JMenuItem("Find an Account");
        findAcct.addActionListener(ml);
        acctMenu.add(findAcct);

        bar = new JMenuBar( );
        bar.add(fileMenu);
        bar.add(acctMenu);
	bar.add(transMenu);
        setJMenuBar(bar);
    }
	
    private class MenuListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event) 
      {
        String source = event.getActionCommand();

        if (source.equals("New Transaction"))
        {
            Assignment5.newTransaction();
		}
        else if (source.equals("List all Transactions"))
		{
            List = 1;
            Assignment5.c.GenerateList();
		}	   
        else if (source.equals("List all Checks"))
        {
			List = 2;
            Assignment5.c.GenerateList();
		}
        else if (source.equals("List all Deposits"))
		{
            List = 3;
            Assignment5.c.GenerateList();
		}
        else if (source.equals("List all Service Charges"))
		{
            List = 4;
            Assignment5.c.GenerateList();
		}
        else if (source.equals("Write Account"))
        {
			Assignment5.writeCheckingAccount();
		}
        else if (source.equals("Read Account"))
        {
			Assignment5.readCheckingAccount();
		}
		else if (source.equals("Create a new Account"))
        {
			Assignment5.newAccount();
		}
        else if (source.equals("Find an Account"))
        {
			Assignment5.findAccount();
		}
      }
    }
}
