/*An ExceptionPOC class is requesting a number between 1 and 10. Run the program again and enter 5.5.
 Although this number is between 1 and 10, the program will abort. Examine the error message. You 
 should see the word Exception, the method where the exception occurred (main), the class name of 
 the exception (InputMismatchException), as well as the call stack listing the method calls.
Add a try/catch block to catch and handle the InputMismatchException exception. Identify the 
statements that cause the error as well as the portions of the program that depend upon these 
statements. Enclose these statements within the try block. Follow the try block with the catch 
block given below. Note, the InputMismatchException class is defined in java.util and must be imported.
 Also, when the Scanner throws an InputMismatchException, the input token will remain in the buffer so 
 that it can be examined by the program. Complete code by implementing the same using:-
a) Throws method declaration
b) Throw keyword*/
import java.util.*;
class ExceptionPOC{
    public void checkInput(){
        System.out.println("System requestin number from 1 to 10. ");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        input.close();
        if(number <1  || number>10){
            throw new InputMismatchException("demo");
        }
        System.out.println("input is "+number);
    }
   
}
class DP4{
  
    public static void main(String[] args) throws InputMismatchException {
       try{
        var e1=new ExceptionPOC();
        e1.checkInput();
       }catch(InputMismatchException e){
        println("invalid Input:"+e);
       }
    }
    static void println(Object line){
        System.out.println(line);
    }
}