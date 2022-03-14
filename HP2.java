/*Accept a SearchToken from the user.
 Open the file and read it using RandomFileAccess and
search and display total occurrences of the search string in given text.*/

import java.util.Scanner;
import java.io.*;
  class HP2 {
    public void searchToken(){
        int count = 0;
        String line = null;
        Scanner input = new Scanner(System.in);
        System.out.println("\nProgram to search a word in file (case sensitive)");
        System.out.print("\nEnter a word to search in the file: ");
        String word = input.nextLine();
        input.close();
        try {
            RandomAccessFile raf = new RandomAccessFile(new File("HP2.txt"),"r");
            
            
            while((line = raf.readLine())!= null){
                String words[] = line.split(" ");
                for(String a:words){
                    if(a.equals(word) || a.equals(word+".")){
                        count++;
                    }
                }
            }
            System.out.println("\nTotal occurence of '"+ word+ "' : "+ count);
        } catch (Exception e) {
            System.out.println("br:- "+ e);
        }
    }
    public static void main(String[] args) {
        HP2 fp = new HP2();
        fp.searchToken();
    }
}