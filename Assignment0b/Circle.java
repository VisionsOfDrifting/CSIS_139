
package assignment0b;

/**
 * Assignment 0
 * Circle Analyzer
 * Nicholas Pappas
 * CS/IS 139
 */
import java.util.Scanner;
public class Circle 
{    
    double rad;
    public Circle(double radius)
    {
        rad=radius;
    }
 
    public double getRadius()
    {
        return rad;
    }
 
    public double getDiameter()
    {
        return 2.0*rad;
    }
 
    public double getCircumference()
    {
        return 2.0*Math.PI*rad;
    }
   
    public double getArea()
    {
        return Math.PI*rad*rad;
    }
    
}
