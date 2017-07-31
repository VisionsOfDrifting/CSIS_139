
package assignment3;
/**
 * Assignment3
 * Checking Account
 * Nicholas Pappas
 * CS/IS 139
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EOptionsPanel3 extends JPanel
{
   private final JLabel prompt;
   private final JRadioButton one, two, three, four, five;
   public static int List = 0;

   public EOptionsPanel3()
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
      five = new JRadioButton ("List all service charges");
      five.setBackground (Color.white);
    
      ButtonGroup group = new ButtonGroup();
      group.add (one);
      group.add (two);
      group.add (three);
      group.add (four);
      group.add (five);
              
      EOptionListener listener = new EOptionListener();
      one.addActionListener (listener);
      two.addActionListener (listener);
      three.addActionListener (listener);
      four.addActionListener (listener);
      five.addActionListener (listener);
      
      add (prompt);
      add (one);
      add (two);
      add (three);
      add (four);
      add (five);
      
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
             Assignment3.newTransaction();
         }
         if (source == two)
         {
             List = 1;
             Assignment3.c.GenerateList();
         }
         if (source == three)
         {
             List = 2;
             Assignment3.c.GenerateList();
         }
         if (source == four)
         {
             List = 3;
             Assignment3.c.GenerateList();
         }
         if (source == five)
         {
             List = 4;
             Assignment3.c.GenerateList();
         }
      }
   }
}
