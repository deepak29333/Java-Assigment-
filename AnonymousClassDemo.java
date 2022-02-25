/* anonymous class practice*/
class Polygon {
    protected int x=7;
    public void display() {
       System.out.println("Inside the Polygon class");
    }}
 class Dis {
    public void createClass() {
       // creation of anonymous class extending class Polygon
       Polygon p1 = new Polygon() {public void display() {
             System.out.println("Inside an anonymous class. x= "+x);
          }};
       p1.display();
    }}
 class AnonymousClassDemo {
    public static void main(String[] args) {
        Dis an = new Dis();
        an.createClass();}}
 