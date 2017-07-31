package Assignment6;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Assignment6
 * Nicholas Pappas
 * CS/IS 139
 */


public class Assignment6 {

    private static int Choice, compChoice, MAX = 3, again, imageNum, soundNum;
    public static String message;
	
    public static void main (String[] args) throws InterruptedException
   {      
      do{
      getChoice();
      initialImage();
      JFrame frame = new JFrame ("Rock-Paper-Scissors");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new GamePanel());
      frame.pack();
      frame.setVisible(true);
      newGame();
      Thread.sleep(4000);
      again = JOptionPane.showConfirmDialog (null, "Play Again?");}
      while (again == JOptionPane.YES_OPTION);
   }
    
    public static void newGame()
    {
        compChoice =(int)((Math.random() * MAX) + 1);
        if(Choice == compChoice)
        {
            message = "We chose the same\nWe Tie";
            imageNum= 4; soundNum= 5;
        }
        else if(Choice == 1)
		{
			if(compChoice == 2)
			{
				message = "Rock loses to Paper\nYou Lose";
                                imageNum= 2; soundNum= 2;
			}
                        if(compChoice == 3)
			{
				message = "Rock beats Scissors\nYou Win";
                                imageNum= 1; soundNum= 1;
			}
		}
        else if(Choice == 2)
		{
			if(compChoice == 1)
			{
				message = "Paper beats Rock\nYou Win";
                                imageNum= 2; soundNum= 2;
			}
			if(compChoice == 3)
			{
				message = "Paper loses to Scissors\nYou Lose";
                                imageNum= 3; soundNum= 3;
			}
		}
        else if(Choice == 3)
		{
			if(compChoice == 1)
			{
				message = "Scissors loses to Rock\nYou Lose";
                                imageNum= 1; soundNum= 1;
			}
			if(compChoice == 2)
			{
				message = "Scissors beats Paper\nYou Win";
                                imageNum= 3; soundNum= 3;
			}
                }
                JOptionPane.showMessageDialog (null, message);
    }

   public static int getChoice()
   {
       String choiceStr = JOptionPane.showInputDialog ("Enter your choice:\n '1' for Rock\n '2' for Paper\n '3' for Scissors");
       Choice = Integer.parseInt(choiceStr);
       return Choice;
   }
   
   public static int getimageNum()
   {
       return imageNum;
   }
   
   public static int getsoundNum()
   {
       return soundNum;
   }
   public static void initialImage()
   {
       GamePanel.I1 = Choice;
       GamePanel.I2 = compChoice;
   }
}