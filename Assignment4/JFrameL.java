package assignment4;
/**
 * Assignment4
 * Nicholas Pappas
 * CS/IS 139
 */
import javax.swing.*;
import java.awt.event.*;
public class JFrameL extends JFrame
{
    /** Creates a new instance of JFrameL */
    public JFrameL(String title) {
        super(title);
        FrameListener listener = new FrameListener();
        addWindowListener(listener);
    }
   private class FrameListener extends WindowAdapter
   {

    public void windowClosing(WindowEvent e) {
        int confirm;
        if (!Assignment4.saved)
        {
           String  message = "You account data has not been saved.\n"+
               "Would you like to save it before ending this session?";
           confirm = JOptionPane.showConfirmDialog (null, message);
           if (confirm == JOptionPane.YES_OPTION)
           {
               Assignment4.writeCheckingAccount();
           } 
        }
       System.exit(0);
    }
   }   
}
