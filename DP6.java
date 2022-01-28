/*Create an Exception class InvalidProductException that can be thrown if a user adds an invalid product.*/
import java.util.InputMismatchException;
import java.util.Scanner;
class  InvalidProductException extends Exception {  
    private int x;
    InvalidProductException(int p){
        x=p;
    }
    public String toString(){
        return "InvalidProductException "+x;
    }
}
class DP6{
    static final int[] product={1,3,6,85,32,8,9};
    public static void checkProduct(int p) throws InvalidProductException{
        boolean flag=false;
        for(int i=0; i<product.length;i++){
            if(product[i]==p){
                flag=true;
            }
        }
        if(!flag){
            throw new InvalidProductException(p);
        }
    }
    public static void main(String[] args) throws InvalidProductException {
        var input =new Scanner(System.in);
        println("which Product you want add >");
        println("Enter Product id: ");
        int n;
        try {
             n=input.nextInt();
             input.close();
             try {
                checkProduct(n);
            } catch (Exception e) {
               println("InvalidProductException "+e);
            }

        } catch (InputMismatchException e) {
            println("Enter Number only: "+e);
        }
        
    }
    public static void println(Object line){
        System.out.println(line);
    }
}