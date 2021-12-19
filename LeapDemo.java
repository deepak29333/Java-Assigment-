/*To determine whether a year is a leap year, follow these steps:
1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.
2. If the year is evenly divisible by 100, go to step 3. Otherwise, go to step 4.
3. If the year is evenly divisible by 400, go to step 4. Otherwise, go to step 5.
4. The year is a leap year (it has 366 days).
5. The year is not a leap year (it has 365 days).*/ 
import java.util.Scanner;
//nextBoolean(), nextByte(),nextDouble(), nextFloat(), nextInt(),nextLine(), nextLong(),nextShort()
public class LeapDemo {
 public static void main(String[] args) {
    	int year;//variable of type int
		//to use the Scanner class , create an object of the class
    	//Scanner scan;//object reference
		Scanner scan= new Scanner(System.in);
    	System.out.println("Enter any Year:");
    	year = scan.nextInt();
		String name;
		System.out.println("Enter your name:");
		name=scan.nextLine();
    	scan.close();
        boolean isLeap = false;

        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    isLeap = true;
                else
                    isLeap = false;
            }
            else
                isLeap = true;
        }
        else {
            isLeap = false;
        }

        if(isLeap==true)
            System.out.println("Hello"+name+""+year + " is a Leap Year.");
        else
            System.out.println(year + " is not a Leap Year.");
    }
}