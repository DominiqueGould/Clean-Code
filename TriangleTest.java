

import java.awt.Point;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class which tests the Triangle class.
 *
 * @author CS 140 Instructors
 * @author Dominique Gould
 * @version 4-10-18
 */
public class TriangleTest
{
    private Triangle triangle1, triangle2, triangle3;
    private final double EPSILON = 0.0001;
    @Before
    public void setUp()
    {
        triangle1 = new Triangle(new Point(1, 3), 
                          new Point(-2, -2), 
                          new Point(3, -1) );
        
        triangle2 = new Triangle(new Point(1, 5),
                          new Point(-3, 2),
                          new Point(1, -2) );
                          
        triangle3 = new Triangle(new Point(-3, 2),
                          new Point(5, 2),
                          new Point(0, -3) );        
    }

    @Test
    public void test_getSide1_Length()  {
        // rounding side1_Length to two decimal places first
        double roundOff = (double) Math.round(triangle1.getSide1_Length() * 100) / 100;
        
        assertEquals(5.83, roundOff, EPSILON);
    }
    
    
    @Test
    public void test_getSide2_Length() {
        double roundOff = (double) Math.round(triangle1.getSide2_Length() * 100) / 100;
        
        assertEquals(5.10, roundOff, EPSILON);
    }
    
    @Test
    public void test_getSide3_Length() {
        double roundOff = (double) Math.round(triangle1.getSide3_Length() * 100) / 100;
        
        assertEquals(4.47, roundOff, EPSILON);
    }
    
    @Test
    public void test_Angle1()
    {
        double roundOff = (double) Math.round(triangle1.getAngle1() * 100) / 100;
        
        assertEquals(74.74, roundOff, EPSILON);    
    }
    
    @Test
    public void test1_toString() 
    {
        String s = 
        "First Corner Point: [1.0, 3.0]\n" +
        "Second Corner Point: [-2.0, -2.0]\n" +
        "Third Corner Point: [3.0, -1.0]\n" +
        "Side 1 length: 5.83\n" +
        "Side 2 length: 5.10\n" +
        "Side 3 length: 4.47\n" +
        "Angle1: 74.74\n" +
        "Angle2: 57.53\n" +
        "Angle3: 47.73";
        
        assertEquals(s, triangle1.toString());
    }
    
    /**
     * verify toString changes correctly after changing the first Corner
     * point of triangle1 to (1,8)
     */
    @Test
    public void test_setPoint1()
    {
        triangle1.setPoint1(new Point(1, 8));
        String s =
        "First Corner Point: [1.0, 8.0]\n" +
        "Second Corner Point: [-2.0, -2.0]\n" +
        "Third Corner Point: [3.0, -1.0]\n" +
        "Side 1 length: 10.44\n" +
        "Side 2 length: 5.10\n" +
        "Side 3 length: 9.22\n" +
        "Angle1: 88.78\n" +
        "Angle2: 61.99\n" +
        "Angle3: 29.23";
        
        assertEquals(s, triangle1.toString());
    }        
    
    @Test
    public void test2_toString()
    {
        String s = 
        "First Corner Point: [1.0, 5.0]\n" +
        "Second Corner Point: [-3.0, 2.0]\n" +
        "Third Corner Point: [1.0, -2.0]\n" +
        "Side 1 length: 5.00\n" +
        "Side 2 length: 5.66\n" +
        "Side 3 length: 7.00\n" +
        "Angle1: 81.87\n" +
        "Angle2: 53.13\n" +
        "Angle3: 45.00";

        assertEquals(s, triangle2.toString());
    }
    
    @Test
    public void test_setPoint2()
    {
        triangle2.setPoint2(new Point(-3, 0));
        String s =
        "First Corner Point: [1.0, 5.0]\n" +
        "Second Corner Point: [-3.0, 0.0]\n" +
        "Third Corner Point: [1.0, -2.0]\n" +
        "Side 1 length: 6.40\n" +
        "Side 2 length: 4.47\n" +
        "Side 3 length: 7.00\n" +
        "Angle1: 77.91\n"+
        "Angle2: 63.43\n"+
        "Angle3: 38.66";
        
        assertEquals(s, triangle2.toString() );
    }

    @Test
    public void test3_toString()
    {
        String s =
        "First Corner Point: [-3.0, 2.0]\n" +
        "Second Corner Point: [5.0, 2.0]\n" +
        "Third Corner Point: [0.0, -3.0]\n" +
        "Side 1 length: 8.00\n" +
        "Side 2 length: 7.07\n" +
        "Side 3 length: 5.83\n" +
        "Angle1: 75.96\n" +
        "Angle2: 59.04\n" +
        "Angle3: 45.00";

        assertEquals(s, triangle3.toString());
    }
    
    @Test
    public void test_setPoint3()
    {
        triangle3.setPoint3(new Point(-2, -3));
        String s =
        "First Corner Point: [-3.0, 2.0]\n" +
        "Second Corner Point: [5.0, 2.0]\n" +
        "Third Corner Point: [-2.0, -3.0]\n" +
        "Side 1 length: 8.00\n" +
        "Side 2 length: 8.60\n" +
        "Side 3 length: 5.10\n" +
        "Angle1: 78.69\n" +
        "Angle2: 65.77\n" +
        "Angle3: 35.54";
        
        assertEquals(s, triangle3.toString());
    }   
    
    /**
     * Testing getPoint1 method.  Since getPoint1 returns a copy of point1,
     * the Triangle object should not change even if the copy changes.
     */
    @Test
    public void test_getPoint1()
    {
        Point point1 = triangle1.getPoint1();
        point1.setLocation(2, 4);
           
        String s = 
        "First Corner Point: [1.0, 3.0]\n" +
        "Second Corner Point: [-2.0, -2.0]\n" +
        "Third Corner Point: [3.0, -1.0]\n" +
        "Side 1 length: 5.83\n" +
        "Side 2 length: 5.10\n" +
        "Side 3 length: 4.47\n" +
        "Angle1: 74.74\n" +
        "Angle2: 57.53\n" +
        "Angle3: 47.73";
        
        assertEquals(s, triangle1.toString());
    }
}

