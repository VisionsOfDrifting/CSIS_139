
package assignment2;
/**
 * Assignment1
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EOptionsPanel extends JPanel
{
   private final JLabel prompt;
   private final JRadioButton one, two, three, four;
   public static int List = 0;

   public EOptionsPanel()
   {
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
    
      ButtonGroup group = new ButtonGroup();
      group.add (one);
      group.add (two);
      group.add (three);
      group.add (four);
              
      EOptionListener listener = new EOptionListener();
      one.addActionListener (listener);
      two.addActionListener (listener);
      three.addActionListener (listener);
      four.addActionListener (listener);
      
      add (prompt);
      add (one);
      add (two);
      add (three);
      add (four);
      
      setBackground (Color.white);
      setPreferredSize (new Dimension(400, 100));
   }

   private class EOptionListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
         Object source = event.getSource();

         if (source == one)
         { 
             Assignment2.newTransaction();
         }
         if (source == two)
         {
             List = 1;
             checkingaccount2.GenerateList();
         }
         if (source == three)
         {
             List = 2;
             checkingaccount2.GenerateList();
         }
         if (source == four)
         {
             List = 3;
             checkingaccount2.GenerateList();
         }
      }
   }
}
