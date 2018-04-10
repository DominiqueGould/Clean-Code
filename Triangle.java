/**
 * A class to represent a triangle in two-dimensional space.
 * 
 * @author Dominique Gould
 * @version 4-10-18
 */

import java.awt.Point;

public class Triangle {
    private Point point1, point2, point3;
    private double side1, side2, side3;
    private double largestSide, mediumSide, smallestSide;
    private double angle1, angle2, angle3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = new Point(point1);
        this.point2 = new Point(point2);
        this.point3 = new Point(point3);
        computeAngles();
    }
    
    private void computeAngles() {
        calculateSideLengths();
        findLargestSmallestAndMediumSide();

        double smallSquared = Math.pow(smallestSide, 2);
        double mediumSquared = Math.pow(mediumSide, 2);
        double largeSquared = Math.pow(largestSide, 2);
        double numerator = smallSquared + mediumSquared - largeSquared;
        double denominator = 2 * mediumSide * smallestSide;
        double angle1Cos = numerator / denominator;
        double angle1Radians = (Math.acos(angle1Cos));
        angle1 = Math.toDegrees(angle1Radians);
        
        double aSinC = (mediumSide * Math.sin(angle1Radians));
        double angle2Sin = aSinC / largestSide;
        angle2 = Math.toDegrees(Math.asin(angle2Sin));
        
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
        if ((side1 >= side2) && (side2 >= side3)) {
            largestSide = side1;
            mediumSide = side2;
            smallestSide = side3;
        } else if ((side1 >= side3) && (side3 >= side2)) {
            largestSide = side1;
            mediumSide = side3;
            smallestSide = side2;
        } else if ((side2 >= side1) && (side1 >= side3)) {
            largestSide = side2;
            mediumSide = side1;
            smallestSide = side3;
        } else if ((side2 >= side3) && (side3 >= side1)) {
            largestSide = side2;
            mediumSide = side3;
            smallestSide = side1;
        } else if ((side3 >= side1) && (side1 >= side2)) {
            largestSide = side3;
            mediumSide = side1;
            smallestSide = side2;
        } else if ((side3 >= side2) && (side2 >= side1)) {
            largestSide = side3;
            mediumSide = side2;
            smallestSide = side1;
        }
    }
    
    public double getSide1_Length() {
        return side1;
    }
    
    public double getSide2_Length() {
        return side2;
    }
    
    public double getSide3_Length() {
        return side3;
    }

    public void setPoint1(Point point1) {
        this.point1 = new Point(point1);
        computeAngles();
    }
    
    public void setPoint2(Point point2) {
        this.point2 = new Point(point2);
        computeAngles();
    }
    
    public void setPoint3(Point point3) {
        this.point3 = new Point(point3);
        computeAngles();
    }
    
    public Point getPoint1() {
        return new Point(point1);
    }
    
    public Point getPoint2() {
        return new Point(point2);
    }
    
    public Point getPoint3() {
        return new Point(point3);
    }
    
    public double getAngle1() {
        return angle1;
    }
    
    public double getAngle2() {
        return angle2;
    }
    
    public double getAngle3() {
        return angle3;
    }
    
    public String toString() {
        String side1_Length_String = String.format("%1.2f", side1);
        String side2_Length_String = String.format("%1.2f", side2);
        String side3_Length_String = String.format("%1.2f", side3);
        String angle1_String = String.format("%1.2f", angle1);
        String angle2_String = String.format("%1.2f", angle2);
        String angle3_String = String.format("%1.2f", angle3);
        String triangleInfo =
            "First Corner Point: [" + (double)point1.getX() + ", "
            + (double)point1.getY() + "]" + "\n"
            + "Second Corner Point: [" + (double)point2.getX() + ", "
            + (double)point2.getY() + "]" + "\n"
            + "Third Corner Point: [" + (double)point3.getX() + ", "
            + (double)point3.getY() + "]" + "\n"
            + "Side 1 length: " + side1_Length_String + "\n"
            + "Side 2 length: " + side2_Length_String + "\n"
            + "Side 3 length: " + side3_Length_String + "\n"
            + "Angle1: " + angle1_String + "\n"
            + "Angle2: " + angle2_String + "\n"
            + "Angle3: " + angle3_String;
        return triangleInfo;
    }
}