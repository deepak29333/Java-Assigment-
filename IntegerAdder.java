/*integer adder using command line argument
Explore the basic java program development scenario in Notepad++ and cmd by creating an Integer Adder.
 The adder prints sum of 5 integer numbers without using single variable where input will be taken
  through command line arguments.
a)	Perform the above code using a function and call it in main ().
*/
class IntergerAdder {
    public static void main(String arg[]) {
        if (arg.length == 5) {
            System.out.println(sum(
                    Integer.parseInt(arg[0]),
                    Integer.parseInt(arg[1]),
                    Integer.parseInt(arg[2]),
                    Integer.parseInt(arg[3]),
                    Integer.parseInt(arg[4])));
        } else {
            System.out.println("Error: You have to Pass 5 Command line argument.");
        }
    }

    static int sum(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }
}