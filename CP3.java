/**A java based program which prompts user for the number of students in a class   (a   non-negative	integer),
and	saves	it    in	an int variable called numStudents. It then prompts user for the grade of each of the 
students (integer between 0 to 100) and saves them in an int array called grades. The program shall then compute
 and print the average (in double rounded to 2 decimal places) and minimum/maximum (in int).*/
 import java.util.Scanner;
 class CP3{
     public static void main(String[] args){
        var input= new Scanner(System.in);
        println("Enter the number of Student in a class");
        int numStudent=input.nextInt();
        int[] grade=new int[numStudent];
        println("Enter every Student grade");
        for(int i=0;i<numStudent;i++){
            print("enter "+(i+1)+" grade: ");
            grade[i]=input.nextInt();
            println("");
        }
        input.close();
        print_r(grade);//printing array element
        println("avarage Grade of Student is: "+doubleRound(avarage(grade),2));
        println("Minimin Grade: "+min(grade));
        println("Maximum Grade: "+max(grade));
        
     }
     public static void println(Object line) {
         System.out.println(line);
     }
     public static void print(Object line) {
        System.out.print(line);
    }
    public static void print_r(int arr[]){
        for(int i=0;i<arr.length;i++){
            print(arr[i]+" ");
        }
    }
    public static double avarage(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        } 
        return (double)sum/arr.length;
    }
    public static double doubleRound(double num, int UpToDecimal){
        UpToDecimal=UpToDecimal+1;
        String strNum=String.valueOf(num);
        int index=strNum.indexOf(".");
        String newStr=strNum.substring(0,index)+strNum.substring(index,index+UpToDecimal);
        return Double.parseDouble(newStr);
    }
    public static int min(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min; 
    }
    public static int max(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max; 
    }
 }