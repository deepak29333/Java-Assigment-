/*Create a Waffle Class having two data members flavor and price, being populated by a parameterized constructor. 
Create another class WaffleMain to compare the values and object context of Waffle class data members by
 equals() and ==. Extend the implementation to get desired results by overriding 
a) equals()
b) toString()*/
import java.util.Scanner;
class WaffleMain{
       public static void main(String[] args) {
       
        Waffle c1=new Waffle("Vanilla",50);
        Waffle c2=new Waffle("Vanilla", 50);
        if(c1.equals(c2)){
            println(c1.toString(c2));
            println("Both Are Equal");
        }
        else{
            println(c1.toString(c2));
            println("Not Equal");
        }
    }
    public static void println(Object Line){
        System.out.println(Line);
    }
}
class Waffle{
    String flavour;
    int price;
    public Waffle(String Flavour, int Price){
        this.flavour=Flavour;
        this.price=Price;
    }
    // @Override
    public boolean equals(Waffle O){
        
        if(this.flavour==O.flavour && this.price==O.price){
            return true;
        }else{
            return false;
        }
        
    }
    public String toString(Waffle O){
        return this.flavour+"="+O.flavour+" and "+this.price+"="+O.price;
    }

}