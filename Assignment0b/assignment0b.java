
package assignment0b;

/**
 * Assignment 0
 * Circle Analyzer
 * Nicholas Pappas
 * CS/IS 139
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class assignment0b
{

    public static void main(String[] args)
    {
        double swamp;
        swamp = getRadius();
        Circle Shrek= new Circle(swamp);
        DecimalFormat fmt = new DecimalFormat ("0.##");
        System.out.println("Your circle has dimensions of:");
        System.out.println("Radius: "+ Shrek.getRadius());
        System.out.println("Diameter: "+ fmt.format(Shrek.getDiameter()));
        System.out.println("Circumference: "+ fmt.format(Shrek.getCircumference()));
        System.out.println("Area: "+ fmt.format(Shrek.getArea()));
    }    
    public static double getRadius()
   {
       double radius;
       Scanner rad = new Scanner(System.in);
       System.out.print("Type the radius of your circle the hit enter: ");
       radius = rad.nextDouble();
       return radius;
   }
}
