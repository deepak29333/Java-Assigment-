/*create a class called fruits that has a method mango() that tells if the mango is sweet or sour.
 Suppose we need a sour mango in taste for only 1 time. Realize this temporary requirement through
  an anonymous inner class?*/
  class Fruits{
      public  void mango() {
          System.out.println("Mango is Sweet");
      }
  }
  class GP1{
      public static void main(String[] args) {
          // if mango is sweet
          Fruits f1 =new Fruits();
          f1.mango();
          //if mango is Sour
          Fruits f = new Fruits(){
              public void mango(){
                  System.out.println("mango is sour");
              }
          };
          f.mango();
      }
  }