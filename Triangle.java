
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
    private Point point1;
    private Point point2;
    private Point point3;
    private double side1 = 0.0, side2 = 0.0, side3 = 0.0;
    private double largestSide = 0.0, mediumSide = 0.0, smallestSide = 0.0;
    private double angle1;
    private double angle2;
    private double angle3;

    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(Point point1, Point point2, Point point3)
    {
        this.point1 = new Point(point1);
        this.point2 = new Point(point2);
        this.point3 = new Point(point3);
        computeAngles();
    }
    
    /**
     * A method that calculates angle1, angle2, and angle3 based on the side lengths of the triangle.
     */
    private void computeAngles()
    {
        calculateSideLengths();
        findLargestSmallestAndMediumSide();

        double angle1Cos = (Math.pow(smallestSide, 2) + Math.pow(mediumSide, 2) - Math.pow(largestSide, 2)) /
                      (2 * mediumSide * smallestSide);
        double angle1Radians = (Math.acos(angle1Cos));
        angle1 = Math.toDegrees(angle1Radians);

        angle2 = Math.toDegrees(Math.asin((mediumSide * Math.sin(Math.toRadians(angle1)))/ largestSide));

        angle3 = 180 - angle1 - angle2;
    }
    
    public void calculateSideLengths() {
        double a1_Squared = Math.pow((point2.getX()-point1.getX()), 2);
        double b1_Squared = Math.pow((point2.getY()-point1.getY()), 2);
        double c1_Squared = a1_Squared + b1_Squared;
        side1 = Math.sqrt(c1_Squared);
        
        double a2_Squared = Math.pow((point3.getX()-point2.getX()), 2);
        double b2_Squared = Math.pow((point3.getY()-point2.getY()), 2);
        double c2_Squared = a2_Squared + b2_Squared;
        side2 = Math.sqrt(c2_Squared);
        
        double a3_Squared = Math.pow(point3.getX()-point1.getX(), 2);
        double b3_Squared = Math.pow(point3.getY()-point1.getY(), 2);
        double c3_Squared = a3_Squared + b3_Squared;
        side3 = Math.sqrt(c3_Squared);
    }
    
    public void findLargestSmallestAndMediumSide() {
        if ((side1 >= side2) && (side2 >= side3))
        {
            largestSide = side1;
            mediumSide = side2;
            smallestSide = side3;
        }
        else if ((side1 >= side3) && (side3 >= side2))
        {
            largestSide = side1;
            mediumSide = side3;
            smallestSide = side2;
        }
        else if ((side2 >= side1) && (side1 >= side3))
        {
            largestSide = side2;
            mediumSide = side1;
            smallestSide = side3;
        }
        else if ((side2 >= side3) && (side3 >= side1))
        {
            largestSide = side2;
            mediumSide = side3;
            smallestSide = side1;
        }
        else if ((side3 >= side1) && (side1 >= side2))
        {
            largestSide = side3;
            mediumSide = side1;
            smallestSide = side2;
        }
        else if ((side3 >= side2) && (side2 >= side1))
        {
            largestSide = side3;
            mediumSide = side2;
            smallestSide = side1;
        }
    }
    
    /**
     * A method that computes the length of Side1.
     * @return the length of Side1
     */
    public double getSide1_Length()
    {
        return side1;
    }
    
     /**
     * A method that computes the length of Side2.
     * @return the length of Side1
     */
    public double getSide2_Length()
    {
        return side2;
    }
    
    /**
     * A method that computes the length of Side3.
     * @return the length of Side3
     */
    public double getSide3_Length()
    {
        return side3;
    }

    /**
     * A method that sets point 1 of the triangle.
     */
    public void setPoint1(Point point1)
    {
        this.point1 = new Point(point1);
        computeAngles();
    }
    
    /**
     * A method that sets point 2 of the triangle.
     */
    public void setPoint2(Point point2)
    {
        this.point2 = new Point(point2);
        computeAngles();
    }
    
    /**
     * A method that sets point 3 of the triangle.
     */
    public void setPoint3(Point point3)
    {
        this.point3 = new Point(point3);
        computeAngles();
    }
    
    /**
     * A method that returns point 1 of the triangle.
     * @return point 1
     */
    public Point getPoint1()
    {
        return new Point(point1);
    }
    
    /**
     * A method that returns point 2 of the triangle.
     * @return point 2
     */
    public Point getPoint2()
    {
        return new Point(point2);
    }
    
    /**
     * A method that returns point 3 of the triangle.
     * @return point 3
     */
    public Point getPoint3()
    {
        return new Point(point3);
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
        String side1_Length_String = String.format("%1.2f", side1);
        String side2_Length_String = String.format("%1.2f", side2);
        String side3_Length_String = String.format("%1.2f", side3);
        String angle1_String = String.format("%1.2f", angle1);
        String angle2_String = String.format("%1.2f", angle2);
        String angle3_String = String.format("%1.2f", angle3);
        String triangleInfo = "First Corner Point: [" + (double)point1.getX() + ", " + (double)point1.getY() + "]" + "\n" + "Second Corner Point: [" + (double)point2.getX() + ", " + (double)point2.getY() + "]" + "\n" + "Third Corner Point: [" + (double)point3.getX() + ", " + (double)point3.getY() + "]" + "\n" + "Side 1 length: " + side1_Length_String + "\n" + "Side 2 length: " + side2_Length_String + "\n" + "Side 3 length: " + side3_Length_String + "\n" + "Angle1: " + angle1_String + "\n" +"Angle2: " + angle2_String + "\n" + "Angle3: " + angle3_String;
        return triangleInfo;
    }
}