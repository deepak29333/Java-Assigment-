
/*
 * Construct a number generator to accept three digits (i.e. 0 - 9) and print
 * all its possible combinations.
 * (For example if the three digits are 1, 2, 3 than all possible combinations
 * are: 123, 132,213, 231, 312, 321.)
 */
import java.util.Scanner;

class Combinations {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[3];
        println("Enter three number: ");
        for (int i = 0; i < 3; i++) {
            nums[i] = scan.nextInt();
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    if (x != y && y != z && z != x) {
                        println(nums[x] + "" + nums[y] + "" + nums[z]);
                    }
                }
            }
        }

    }

    static void println(Object line) {
        System.out.println(line);
    }
}