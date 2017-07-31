package Assignment6;

import java.applet.*;
import java.net.*;

public class PlaySound {
    public static void myPlay(String url) throws InterruptedException
    {

        try
           {
                long delay = 3;
                AudioClip clip = Applet.newAudioClip(new URL(url));
                clip.play();
                Thread.sleep(delay);

            } catch (MalformedURLException murle) {
                System.out.println(murle);
                }
    }
}