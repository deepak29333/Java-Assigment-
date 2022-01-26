
/*Create an interface GeoAnalyzer with a constant PI and methods area() and perimeter().
 Let Circle, Ellipse and rectangle implement this class. Define a class Geometry that
  assigns appropriate objects to GeoAnalyzer reference variable.*/
  interface GeoAnalyzer{
      double pi=3.14;
      public double area();
      public double perimeter();  
  }
  class Circle implements GeoAnalyzer{
      int radius;
      Circle(int radius){
          this.radius=radius;
      }
      public double area(){
          return pi*radius*radius;
      }
      public double perimeter(){
          return 2*pi*radius;
      }
  }
  class Ellipse implements GeoAnalyzer{
      int a;//x-axis
      int b; //y-axis
      Ellipse(int a, int b){
          this.a=a;
          this.b=b;
      }
      public double area(){
          return pi*a*b;
      }
      public double perimeter(){
          double n=Math.sqrt((a^2+b^2)/2);
          return 2*pi*n;
      }
  }
  class CP10{
    public static void main(String args[]){
        GeoAnalyzer g;
        var c1= new Circle(10);
        g=c1;
        println("area of Circe is "+g.area());
        println("perimeter of circel is "+ g.perimeter());
        var e1 =new Ellipse(2,6);
        g=e1;
        println("area of ellipse is "+g.area());
        println("perimeter of ellipse is "+g.perimeter());
    }
    public static void println(Object line){
        System.out.println(line);
    }
  }