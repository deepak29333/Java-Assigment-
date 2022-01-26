/*Extend your Gravity Calculator code (Assignment AA1) to handle exceptions through a try-catch 
finally block. Handle provision for a divide by zero scenarios caught by NumberFormatException. 
Explicitly invoke this exception in execution and observe the response.*/

/*A Gravity Calculator in java to compute the position of an object after falling for 10 seconds, outputting the position in meters. The formula in Math notation is:
x(t) = 0.5 × at 2 + vit + xi

Variable		Meaning	Value a	
Acceleration (m/s 2)         -9.81
t	Time (s)	10

vi	Initial velocity (m/s)       0
xi	Initial position	0 */
// v= u+gt;  velocity after time 
// import java.lang.*;
class GravityCalculator{
    double ix=0; //initial position
    double iv=0; // initial velocity
    double time=10; // in seconds
    double fv=0.0; //final velocity
    double fx=0.0; //final position
    public final double a= -9.81; //acceleration 
    public final double g=9.8;// m/s
 
    public double finalVelocity(double initialVelocity, int time){
        // int p =10/0;
        // System.out.println(p);
        return initialVelocity+g*time;
    }
    public double finalPosition(int time, double initialVelocity){
         fx= 0.5*a*time*time+finalVelocity(initialVelocity,time);
        return fx-ix;
    }
    public double initialVelocity(int t){
        double result=0;
        try {
            double result1=(fx-ix-0.5*a*time*time);
             result=result1/t;
             // manually through exceptions
             throw new ArithmeticException("Demo");

        } catch (ArithmeticException e) {
            
           System.out.println("divide by Zero:- Time should be greater than 1sec ");
        }finally{
            System.out.println("this is final block");
        }
        return result;
    }
}
class DP1{
    public static void main(String[] args) {
        var gc1=new GravityCalculator();
        println(gc1.finalPosition(10,5));
        println(gc1.initialVelocity(0));
        
    }
    public static void println(Object line){
        System.out.println(line);
    }
}