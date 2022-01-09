/*Demonstrate the working of a Static Inner Class through a class Electronics and within it create Static Inner
 Class Television that has a method cost() which displays cost of television object passed in constructor of
  Television class. Demonstrate invoking inner class method with outer object when the method cost() is once a :-
a) Instance(Non static) method
 b) Static method */
 class CP4{
       public static void main(String[] args) {
           var n= new Electronics(); 
           n.callInnserClass();
           
       }
 }
 class Electronics{
    static int Scost=5000;
    int NonScost=4000;
    void callInnserClass(){
        Television t=new Television();
        t.cost();
    }
    class Television{
        void cost(){
            //for upper class static function can be accessed by class name . method name;
            Electronics.staticPrint("Static print - Cost of staic is:  "+Scost);
            // we can access upper call variable and method directly 
            println("non Static Directly - cost of Non staic is : "+NonScost);
            Electronics objEl=new Electronics();
            // we can access upper call variable and method directly and by instance 
            objEl.println("non Static By Instance - cost of Non staic is : "+objEl.NonScost);
        }
    }
    public static void staticPrint(Object line){
        System.out.println(line);
    }
    public void println(Object line){
        System.out.println(line);
    }
 }