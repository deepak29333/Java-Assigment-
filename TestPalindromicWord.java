/*A word that reads the same backward as forward is called a palindrome, e.g., "mom", "dad", "racecar", "madam", and "Radar"
 (case-insensitive). Create a class called TestPalindromicWord, that prompts user for a word and
prints ""xxx" is|is not a palindrome".*/
import java.util.Scanner;
class TestPalindromicWord{
    public static void main(String arg[]){
        var in=new Scanner(System.in);
        println("Enter a word to test is it palindrom of not: ");
        String word=in.next();
        in.close();
        string p =new string();

        if(p.isPalindrom(word)){
            println("This is a Palindrom");
        }else{
            println("This is not Palindrom");
        }
    }
    public static void println(Object Line){
        System.out.println(Line);
    }
}

 class string{
    public boolean isPalindrom(String word){
        word=word.toLowerCase();
        boolean flag=true;
        int n=word.length();
        for(int i=0;i<n/2;i++){
            if(word.charAt(i)!=word.charAt(n-1-i)){
                flag=false;
                return false;
            }
        }
        return flag;
    }
 }