/* sum of reciprocal of from 1 to 10 without using single variable */
class ReciprocalSum {
    public static void main(String arg[]) {
        float sum = 0;
        for (float i = 1; i <= 10; i++) {
            if (i == 10)
                System.out.print("1/" + i);
            else
                System.out.print("1/" + i + "+");

            sum = sum + 1 / i;
        }
        System.out.println("");
        System.out.println("Sum of series is: " + sum);
    }
}
