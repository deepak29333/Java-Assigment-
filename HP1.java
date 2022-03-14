/*A String tokenizer application to store the input string contents in a file. Read the file
 and count vowels, consonants and spaces in each line. Create another file to write the vowel
  and consonant count besides each line. For eg:- Hi this is java(vowels-5, consonents-7, spaces- 3).
   I like studying it(vowels-6, consonants-9, spaces-4). Perform this operation using:
 a) BufferedReader and BufferedWriter 
b) FileReader and FileWriter
*/
import java.io.*;
public class HP1 {
    public void readVCS(){
        BufferedWriter bw = null;
        BufferedReader br = null;
        String line = null;
        char ch =' ';
        int consonants = 0, vowels = 0, spaces = 0;

        try {
             br = new BufferedReader(new FileReader("test.txt"));
             bw = new BufferedWriter(new FileWriter("test2.txt", true));
             while((line = br.readLine())!= null){
                for(int i=0; i<line.length(); i++){
                    ch = line.charAt(i);
                    if(ch=='a' ||ch=='e' ||ch=='i' ||ch=='o' ||ch=='u' ||
                    ch=='A' ||ch=='E' ||ch=='I' ||ch=='O' ||ch=='U'){
                        vowels++; 
                    } 
                    else if(ch==' '){
                        spaces++;
                    }
                    else{
                        consonants++;
                    }
                }
                 System.out.println("Line:- '"+ line+ "'");
                System.out.println("Vowels: "+ vowels);
                System.out.println("Consonants: "+ consonants);
                System.out.println("Spaces: "+ spaces);
                System.out.println("---------------------------------");

                try {
                     bw.write("Line:- '"+ line+ "'");
                    bw.write("\nVowels: "+ vowels);
                    bw.write("\nConsonants: "+ consonants);
                    bw.write("\nSpaces: "+ spaces);
                    bw.write("\n---------------------------------");
                } catch (Exception e) {
                    System.out.println("bw:- "+ e);
                }

                vowels = 0; consonants = 0; spaces = 0;
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            System.out.println("br:- "+ e);
        }
    }
    public static void main(String[] args) {
    	HP1 st = new HP1();
        st.readVCS();
    }
}
