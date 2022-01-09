/*
Design a class called DecipherCaesarCode to decipher the Caesar's code. The program shall prompts user for a ciphertext
string consisting of mix-case letters only; compute the plaintext; and print the plaintext in uppercase. Design the
solution with appropriate methods?*/
import java.util.Scanner;

class DecipherCaesarCode{
    public static void main(String[] args) {
        var in =new Scanner(System.in);
        println("Enter String To Encrypy:");
        String text=in.nextLine();
        println("Enter Shift Number:");
        int shift=in.nextInt();
        in.close();
        var cpObj= new Crytography();
        println("Encrypted Text is:");
        println(cpObj.encrypt(text,shift));
        println("Decrypted Text is:");
        println(cpObj.decrypt());
    }
    public static void println(Object Line) {
       System.out.println(Line);  
    }

}
class Crytography{
    String encrp;
    int shift;
    public final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String text, int shift){
        this.shift=shift;
        text=text.toLowerCase();
        String str="";
        for(int i=0;i<text.length();i++){
            int index=ALPHABET.indexOf(text.charAt(i));
            int shiftTo=(index+shift)%26;
            str=str+ALPHABET.charAt(shiftTo);
        }
        this.encrp=str;
        return str;
    }
    public String decrypt(){
        String str="";
        for(int i=0;i<encrp.length();i++){
            int index=ALPHABET.indexOf(encrp.charAt(i));
            int shiftTo=(index-shift)%26;
            if (shiftTo < 0)
            {
                shiftTo = ALPHABET.length() + shiftTo;
            }
            str=str+ALPHABET.charAt(shiftTo);
        }
        return str.toUpperCase();
    }
}   