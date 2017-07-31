package Assignment6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel
{
   private final int WIDTH = 400, HEIGHT = 150;
   private final int DELAY = 150, IMAGE_SIZE = 35;
   public static String[] imageList = { "rock.jpg","paper.jpg","scissors.jpg","tiegame.jpg"};
   public static String[] soundList = {"rockwin.wav","paperwin.wav","scissorswin.wav","gamestart.wav","tiegame.wav"};
   private static ImageIcon image, image2;
   private static int imageNum, soundNum;
   public static Timer timer;
   public static int y, moveX, moveY, moveX2, x1, x2, I1, I2;

   public GamePanel()
   {
      timer = new Timer(DELAY, new RPSListener());
      x1=0; x2=380; y = 80;
      moveX = 20; moveX2 = -20; moveY = -5;
      setPreferredSize (new Dimension(WIDTH, HEIGHT));
      setBackground (Color.black);
      timer.start();
   }

   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      if (image !=null)
      {image.paintIcon (this, page, x1, y);}
      if (image2 !=null)
      {image2.paintIcon (this, page, x2 , y);}
   }
   
   private class RPSListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
         String url, baseurl = "file:";
         x1 += moveX;
         x2 += moveX2;
         moveY *= -1;
         y += moveY;
         if (x1==moveX)
         {
             try
             {
                url =baseurl+soundList[4];
                PlaySound.myPlay(url);
             }
             catch (InterruptedException ie) {
                System.out.println(ie);
                }
         }
        if (x1 < WIDTH-IMAGE_SIZE)
           {
              image = new ImageIcon (imageList[I1]);
              image2 = new ImageIcon (imageList[I2]);
              repaint();
           }  
         if (x1 == x2)
           {
              timer.stop();
              //image2 = null;
              imageNum = Assignment6.getimageNum();
              image = new ImageIcon (imageList[imageNum]);             
              repaint();
                try
                {
                soundNum = Assignment6.getsoundNum();
                PlaySound.myPlay(soundList[soundNum]);
                }
               catch (InterruptedException ie) {
                System.out.println(ie);
                }
          }
      }
   }
}
