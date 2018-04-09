
/**
 * A class to represent a triangle in two-dimensional space.
 * 
 * @author Dominique Gould
 * @version 3-8-17
 */
import java.awt.Point;
public class Triangle
{
    // instance variables - replace the example below with your own
    private Point p1;
    private Point p2;
    private Point p3;
    private double angle1;
    private double angle2;
    private double angle3;

    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(Point p1, Point p2, Point p3)
    {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
        computeAngles();
    }

    /**
     * A method that computes the length of Side1.
     * @return the length of Side1
     */
    public double getSide1_Length()
    {
        return Math.sqrt(Math.pow((p2.getX()-p1.getX()),2)+Math.pow((p2.getY()-p1.getY()), 2));
    }
    
    /**
     * A method that computes the length of Side2.
     * @return the length of Side1
     */
    public double getSide2_Length()
    {
        return Math.sqrt(Math.pow((p3.getX()-p2.getX()),2)+Math.pow((p3.getY()-p2.getY()), 2));
    }
    
    /**
     * A method that computes the length of Side3.
     * @return the length of Side3
     */
    public double getSide3_Length()
    {
        return Math.sqrt(Math.pow(p3.getX()-p1.getX(),2)+Math.pow(p3.getY()-p1.getY(),2));
    }
    
    /**
     * A method that calculates angle1, angle2, and angle3 based on the side lengths of the triangle.
     */
    private void computeAngles()
    {
        double side1 = getSide1_Length();
        double side2 = getSide2_Length();
        double side3 = getSide3_Length();
        double ls = 0.0;
        double ms = 0.0;
        double ss = 0.0;
        
        if ((side1 >= side2) && (side2 >= side3))
        {
            ls = side1;
            ms = side2;
            ss = side3;
        }
        else if ((side1 >= side3) && (side3 >= side2))
        {
            ls = side1;
            ms = side3;
            ss = side2;
        }
        else if ((side2 >= side1) && (side1 >= side3))
        {
            ls = side2;
            ms = side1;
            ss = side3;
        }
        else if ((side2 >= side3) && (side3 >= side1))
        {
            ls = side2;
            ms = side3;
            ss = side1;
        }
        else if ((side3 >= side1) && (side1 >= side2))
        {
            ls = side3;
            ms = side1;
            ss = side2;
        }
        else if ((side3 >= side2) && (side2 >= side1))
        {
            ls = side3;
            ms = side2;
            ss = side1;
        }
        
        
        double angle1Cos = (Math.pow(ss, 2) + Math.pow(ms, 2) - Math.pow(ls, 2)) /
                      (2 * ms * ss);
        double angle1Radians = (Math.acos(angle1Cos));
        angle1 = Math.toDegrees(angle1Radians);

        angle2 = Math.toDegrees(Math.asin((ms * Math.sin(Math.toRadians(angle1)))/ ls));

        angle3 = 180 - angle1 - angle2;
    }

    
    /**
     * A method that sets point 1 of the triangle.
     */
    public void setPoint1(Point p1)
    {
        this.p1 = new Point(p1);
        computeAngles();
    }
    
    /**
     * A method that sets point 2 of the triangle.
     */
    public void setPoint2(Point p2)
    {
        this.p2 = new Point(p2);
        computeAngles();
    }
    
    /**
     * A method that sets point 3 of the triangle.
     */
    public void setPoint3(Point p3)
    {
        this.p3 = new Point(p3);
        computeAngles();
    }
    
    /**
     * A method that returns point 1 of the triangle.
     * @return point 1
     */
    public Point getPoint1()
    {
        return new Point(p1);
    }
    
    /**
     * A method that returns point 2 of the triangle.
     * @return point 2
     */
    public Point getPoint2()
    {
        return new Point(p2);
    }
    
    /**
     * A method that returns point 3 of the triangle.
     * @return point 3
     */
    public Point getPoint3()
    {
        return new Point(p3);
    }
    
    /**
     * A method that returns angle1.
     * @return angle1
     */
    public double getAngle1()
    {
        return angle1;
    }
    
    /**
     * A method that returns angle2.
     * @return angle2
     */
    public double getAngle2()
    {
        return angle2;
    }
    
    /**
     * A method that returns angle3.
     * @return angle3
     */
    public double getAngle3()
    {
        return angle3;
    }
    
    /**
     * A method that prints information about the triangle.
     * @return the corner points, the three side lengths, and the three angles of the triangle.
     */
    public String toString()
    {
        String firstSideLength = String.format("%1.2f", getSide1_Length());
        String secondSideLength = String.format("%1.2f", getSide2_Length());
        String thirdSideLength = String.format("%1.2f", getSide3_Length());
        String firstAngle = String.format("%1.2f", angle1);
        String secondAngle = String.format("%1.2f", angle2);
        String thirdAngle = String.format("%1.2f", angle3);
        String triangleInfo = "First Corner Point: [" + (double)p1.getX() + ", " + (double)p1.getY() + "]" + "\n" + "Second Corner Point: [" + (double)p2.getX() + ", " + (double)p2.getY() + "]" + "\n" + "Third Corner Point: [" + (double)p3.getX() + ", " + (double)p3.getY() + "]" + "\n" + "Side 1 length: " + firstSideLength + "\n" + "Side 2 length: " + secondSideLength + "\n" + "Side 3 length: " + thirdSideLength + "\n" + "Angle1: " + firstAngle + "\n" +"Angle2: " + secondAngle + "\n" + "Angle3: " + thirdAngle;
        return triangleInfo;
    }
}