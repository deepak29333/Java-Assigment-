/* Create an Array of Student class objects.
a)  Sort them by roll number using Comparable Interface.
b) Perform sort based on alphabetic first name numbering using Comparator */
// import java.io.*;
import java.util.*;
// import java.lang.*;
class Student implements Comparable<Student>{
     String name;
     int roll_no;
    public int compareTo(Student s1){
        return this.roll_no-s1.roll_no;
    }
    public Student(String name, int roll_no){
        this.name=name;
        this.roll_no=roll_no;
    }
    public String getName(){
        return name;
    }
    public int getRollNo(){
        return roll_no;
    }
}
class compareName implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}

class CP8 {
    public static void main(String arg[]){
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("Deepak",101));
        list.add(new Student("Jitender",111));
        list.add(new Student("ankit",131));
        list.add(new Student("mohit",109));
        compareName comName = new compareName();
         // short by name 
        // println("array By name before Short");
        // for(Student student:list){
        //     println(student.getRollNo()+" student Name: "+student.getName());
        // }
        Collections.sort(list,comName);
        println("array By name After Short");
        for(Student student1:list){
            println(" student Name: "+student1.getName());
        }
        //short by roll_n0
        // println("array By roll No before Short");
        // for(Student student:list){
        //     println(student.getRollNo()+" student Name: "+student.getName());
        // }
        Collections.sort(list);
        println("array By roll No After Short");
        for(Student student:list){
            println(student.getRollNo()+" student Name: "+student.getName());
        }
       
        
    }
    static void println(Object line){
        System.out.println(line);
    }
}