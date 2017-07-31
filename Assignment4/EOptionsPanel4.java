package assignment4;
/**
 * Assignment4
 * Nicholas Pappas
 * CS/IS 139
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.Set;

public class EOptionsPanel4 extends JPanel
{
   private final JLabel prompt;
   private final JRadioButton one, two, three, four, five, six, seven;
   public static int List = 0;

   public EOptionsPanel4()
   {
      //Set Layout (new Box Layout(this, BoxLayout.Y_AXIS));
       
      prompt = new JLabel ("Select an option below: ");
      prompt.setFont (new Font ("Helvetica", Font.BOLD, 24));

      one = new JRadioButton ("Enter transaction");
      one.setBackground (Color.white);
      two = new JRadioButton ("List all transactions");
      two.setBackground (Color.white);
      three = new JRadioButton ("List all checks");
      three.setBackground (Color.white);
      four = new JRadioButton ("List all deposits");
      four.setBackground (Color.white);
      five = new JRadioButton ("List all service charges");
      five.setBackground (Color.white);
      six = new JRadioButton ("Save Checking Account");
      six.setBackground (Color.white);
      seven = new JRadioButton ("Load Checking Account");
      seven.setBackground (Color.white);
    
      ButtonGroup group = new ButtonGroup();
      group.add (one);
      group.add (two);
      group.add (three);
      group.add (four);
      group.add (five);
      group.add (six);
      group.add (seven);
              
      EOptionListener listener = new EOptionListener();
      one.addActionListener (listener);
      two.addActionListener (listener);
      three.addActionListener (listener);
      four.addActionListener (listener);
      five.addActionListener (listener);
      six.addActionListener (listener);
      seven.addActionListener (listener);
      
      add (prompt);
      add (one);
      add (two);
      add (three);
      add (four);
      add (five);
      add (six);
      add (seven);
      
      setBackground (Color.white);
      setPreferredSize (new Dimension(300, 200));
   }

   private class EOptionListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
         Object source = event.getSource();

         if (source == one)
         { 
             Assignment4.newTransaction();
         }
         if (source == two)
         {
             List = 1;
             Assignment4.c.GenerateList();
         }
         if (source == three)
         {
             List = 2;
             Assignment4.c.GenerateList();
         }
         if (source == four)
         {
             List = 3;
             Assignment4.c.GenerateList();
         }
         if (source == five)
         {
             List = 4;
             Assignment4.c.GenerateList();
         }
         if (source == six)
         {
             Assignment4.writeCheckingAccount();
         }
         if (source == seven)
         {
             Assignment4.readCheckingAccount();
         }
      }
   }
}
