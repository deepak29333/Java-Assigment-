/*Create a class StudentRegistrationCheck that checks eligibility of a student for registration.
If the student age<12 and marks<200 then the student is not eligible for registration. Design 
appropriate solution using exception handling?*/
import java.util.*;
import java.util.Scanner;
class StudentRegistrationCheck{
    int age;
    int marks;
    StudentRegistrationCheck(int age, int marks){
        this.age=age;
        this.marks=marks;
    }
    public boolean isEligible(){
        if(age>12 && marks >200){
            return true;
        }
        else{
            return false;
        }
    }
}
class DP3{
    public static void main(String[] args) {
        var input =new Scanner(System.in);
        try {
            println("Enter your age: ");
            int age=input.nextInt();
            println("Enter your Marks: ");
            int marks= input.nextInt();
            input.close();
            var s1=new StudentRegistrationCheck(age,marks);
            if(s1.isEligible()){
                println("You is eligible.");
            }
            else{
                println("You Are not eligible.");
            }
        } catch (InputMismatchException e) {
            println("Invaid input :"+e);
        }
       
       
    }
    static void println(Object line){
        System.out.println(line);
    }
}