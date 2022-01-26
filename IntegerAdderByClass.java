/*integer adder using command line argument
Explore the basic java program development scenario in Notepad++ and cmd by creating an Integer Adder.
 The adder prints sum of 5 integer numbers without using single variable where input will be taken
  through command line arguments.
  b)	Make another class and a function in it to perform the above task.
  */
class IntegerAdderByClass {
    public static void main(String arg[]) {
        if (arg.length == 5) {
            Adder add = new Adder();
            System.out.println(add
                    .sum(
                            Integer.parseInt(arg[0]),
                            Integer.parseInt(arg[1]),
                            Integer.parseInt(arg[2]),
                            Integer.parseInt(arg[3]),
                            Integer.parseInt(arg[4])));
        } else {
            System.out.println("Error: You have to Pass 5 Command line argument.");

        }
    }
}

class Adder {
    public int sum(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }
}