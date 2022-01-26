/*Create a POC(Proof of Concept) to demonstrate usage of various functions of String Class like:- a) charAt()
b) length()
c) contains()
d) equals and ==
e) indexOf()
f) split()
g) toUpperCase()
*/
import java.util.Scanner;
class ProofOfConcept{
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String[] operations={"length()","contains()","equals()","indexOf()","split()","toUpperCase()"};
        println("there are many String Operation We Are practicing some Function ");
        println("First Enter a string To Perform all Operation");
        String str=scan.nextLine();
        println("Press as Per You want to know.");
        for(int i=0; i<operations.length;i++){
            println(i+" for "+operations[i]);
        }
       
        int input=scan.nextInt();
        scan.nextLine();
        switch(input){
            case 0:
                println("length() is used to find the length if String");
                println("length of Entered String is: "+str.length());
                break;
            case 1:
                println(operations[input]+ " used for to chech substring found in master String:");
                println("Enter Sub String:");
                String subStr=scan.nextLine();
                if(str.contains(subStr)){
                    println("subString found in Master String");
                }else{
                    println("subString Not found in Master String");
                }
                break;
            
            case 2:
                println(operations[input]+" is used to check two Strings are equal or not");
                println("Enter New String To check equal or not With previus String: ");
                String Str1=scan.nextLine();
                if(str.equals(Str1)){
                    println("Both Are equal");
                }else{
                    println("Not equal");
                }
                break;
            case 3:
                println(operations[input]+" is used to index of Character/Sting");
                println("Enter New String To check equal or not With previus String: ");
                String Str2=scan.nextLine();
                println("index of "+Str2+" "+str.indexOf(Str2));
                break;
            case 4:
                println(operations[input]+" is used to Split String into array");
                println("Enter New String/character/space or any special character To split String: ");
                String Str3=scan.nextLine();
                println("splited Sring is ");
                for(String x:str.split(Str3)){
                    println(x);
                }
                break; 
            case 5:
                println(operations[input]+" is used to change LowerCase to UppserCase ");
                println("changed String is: "+str.toUpperCase());
                break;   
            default:
                println("error! wrong input Run again");
                System.exit(0);    

        }
        scan.close();
    }
    public static void println(Object line){
        System.out.println(line);
    }
}