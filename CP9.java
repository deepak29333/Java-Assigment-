/* Create an interface Relatable that compares the size of objects.Any class can implement 
Relatable if there is some way to compare the relative "size" of objects instantiated from the 
class. For strings, it could be number of characters; for books, it could be number of pages;
 for students, it could be weight; and so forth. For planar geometric objects, area would be a 
 good choice while volume would work for three-dimensional geometric objects. All such 
 classes can implement the isLargerThan() method. Create appropriate implementations.*/
 interface Relatable{
     public int isLargerThan();
 } 
 class Books implements Relatable{
     int pages;
     Books(int pages){
         this.pages=pages;
     }
    //  public int compare(){
         
    //  }
 }
 class CP9{

 }