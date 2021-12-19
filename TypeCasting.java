
/*
Demonstrate type conversion in a simple java program by casting and checking output in the followingcases:-
a)	Conversion of int tobyte

b)	Conversion of double toint

c)	Conversion of double tobyte

d)	Conversion of int tochar

e)	Conversion of float toshort
*/
import java.util.Scanner;

class TypeCasting {
    public static void main(String arg[]) {
        boolean again = true;
        while (again) {
            again = false;
            println("Type Casting");
            println("Press 1.  integer to byte");
            println("Press 2.  Double to Int");
            println("Press 3.  Double to byte");
            println("Press 4.  integet  to Char");
            println("Press 5.  float to short");
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            switch (i) {
                case 1: {
                    println("Enter Your Input: ");
                    int intNum = scan.nextInt();
                    byte byteNum = (byte) intNum;
                    println("your input value is: " + intNum);
                    println("value after casting integer to byte your output is " + byteNum);
                }
                    break;
                case 2: {
                    println("Enter Your Input: ");
                    double doubleNum = scan.nextDouble();
                    int intNum = (int) doubleNum;
                    println("your input value is: " + doubleNum);
                    println("value after casting Double to Int your output is " + intNum);
                }
                    break;
                case 3: {
                    println("Enter Your Input: ");
                    double doubleNum = scan.nextDouble();
                    byte byteNum = (byte) doubleNum;
                    println("your input value is: " + doubleNum);
                    println("value after casting Double to byte your output is " + byteNum);
                }
                    break;
                case 4: {
                    println("Enter Your Input: ");
                    int intNum = scan.nextInt();
                    char charValue = (char) intNum;
                    println("your input value is: " + intNum);
                    println("value after casting Integer  to char your output is " + charValue);
                }
                    break;
                case 5: {
                    println("Enter Your Input: ");
                    float floatNum = scan.nextFloat();
                    short shortNum = (short) floatNum;
                    println("your input value is: " + floatNum);
                    println("value after casting Float  to Short your output is " + shortNum);
                }
                    break;
                default:
                    println("Warning! Wrong input");
                    println("If You Want to continue Press 1");
                    int wantAgain = scan.nextInt();
                    if (wantAgain == 1) {
                        again = true;
                    }
            }
        }
    }

    static void println(Object line) {
        System.out.println(line);
    }

    static void print(Object line) {
        System.out.print(line);
    }
}