
/*
 * A java standalone application makes use of a parameterized method inside a
 * class. Take
 * the following case: Create a class Box and define a method in this class
 * which will return the
 * volume of the box. Initialize two objects for your class and print out the
 * volumes respectively.
 */
import java.util.Scanner;

public class Box {
    double l;
    double b;
    double h;

    Box(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    double volume() {
        return l * b * h;
    }

    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        println("Enter length: ");
        double l = scan.nextDouble();
        println("Enter breath: ");
        double b = scan.nextDouble();
        println("Enter hright: ");
        double h = scan.nextDouble();
        scan.close();
        Box box1 = new Box(l, b, h);
        Box box2 = new Box(5, 15, 20);
        println("Box class has two Objects: Data for first box is entered by User and for Second I keen static 5 l, 15 b and 20 h ");
        println("The Volume of Box is: " + box1.volume());
        println("The Volume of Box is: " + box2.volume());
    }

    static void println(Object line) {
        System.out.println(line);
    }

}