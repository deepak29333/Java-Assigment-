
/*
 * A java standalone application reads in a sentence from the user
 * and prints it out with each word
 * reversed, but with the words and punctuation in the
 * eg- deep,ak kum'sh 249999,90
 *  output kape,ep 
 */
import java.util.Scanner;

class ReverseSentance {
    public static void main(String[] args) {
        println("Enter a Sentence to Reverse: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        println("Enter sentence is: " + str);
        String[] subStr = str.split(" ");
        String revStr = "";
        for (int i = 0; i < subStr.length; i++) {
            String revWord = "";
            for (int j = (subStr[i].length()) - 1; j >= 0; j--) {
                char ch = subStr[i].charAt(j);
                revWord = revWord + ch;

            }
            revStr += revWord + " ";
        }
        println(revStr);

    }

    static void println(Object line) {
        System.out.println(line);
    }
}