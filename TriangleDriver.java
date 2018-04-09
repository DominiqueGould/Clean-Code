import java.awt.Point;
import java.util.Scanner;
/**
 * The Driver class for Triangle.
 *
 * @Dominique Gould
 * @version
 */
public class TriangleDriver
{
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter x coordinate for point 1: ");
        int x1 = console.nextInt();
        System.out.print("Enter y coordinate for point 1: ");
        int y1 = console.nextInt();
        Point point1 = new Point(x1, y1);
        System.out.print("Enter x coordinate for point 2: ");
        int x2 = console.nextInt();
        System.out.print("Enter y coordinate for point 2: ");
        int y2 = console.nextInt();
        Point point2 = new Point(x2, y2);
        System.out.print("Enter x coordinate for point 3: ");
        int x3 = console.nextInt();
        System.out.print("Enter y coordinate for point 3: ");
        int y3 = console.nextInt();
        Point point3 = new Point(x3, y3);
        Triangle triangle = new Triangle(point1, point2, point3);
        System.out.println(triangle.toString());
}
}