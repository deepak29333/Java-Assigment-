/*BP2
Create a class named DuplicateFinder which initializes an array of at least 15 elements. 
Define appropriate methods to print its elements and calculate duplicate elements if any.
 It should detail the number of duplicates along with their frequency of occurrence.*/
import java.util.Scanner;
class DuplicateFinder{
    public static void main(String[] args) {
        boolean flag=true;
        int n=0;
        Scanner scan =new Scanner(System.in);

        while(flag){
            println("Enter Number of Element of array: Note greater than equal 15 ");
            n=scan.nextInt();
            if(n<15){
                flag=true;
                println("!Error:- Enter greater than  eqaul 15");
            }
            else{
                flag=false;
            }
        }
        
        int arr[]= new int[n];
        println("Enter elment of Array:");
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        scan.close();
        println("All array elements ");
        for(int i=0;i<n;i++){
            print(arr[i]+" ");
        }
        println("");
        CheckDupWithFreq(arr);

    }

    static void CheckDupWithFreq(int[] arr){
        boolean flag=true;
        int duplArray[]=new int[arr.length]; //avoid Duplicate line of frequency element 
        //this is time consuming method.    i this this is not optimize code.
        
        for(int i=0; i<arr.length;i++){
            int count=1;
            boolean isCount=false; 
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]==arr[j]){
                    if(!isElement(duplArray,arr[j])){
                        duplArray[i]=arr[j];
                        flag=false;
                        isCount=true;
                        count++;
                    }
                    else{
                        count++;
                    }
                  
                } 
            }
            if(isCount){
                println("Duplicate Element: "+arr[i] +" Frequency: "+ count);
            }
        }
        if(flag){
            println("No Duplicate Element Found.");
        }
    }
    static boolean isElement(int[] arr, int value){
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                flag=true;
                break;
            }
        }
        return flag;
    }















    static void println(Object line){
        System.out.println(line);
    }
    static void print(Object line){
        System.out.print(line);
    }
}