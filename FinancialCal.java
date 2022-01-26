
/*
 * A Financial Calculator to calculate the SimpleInterest and CompoundInterest
 * by taking command line values for principal, rate and time.
 * Extend the code to calculate ‘Final Value’ of investment (V) of an investment
 * (principal P)
 * compounded yearly for T years at interest rate R is given by the formula: V =
 * P (1 + R)T
 * Perform the above code using a function and call it in main().
 * 
 * Make another class and a function in it to perform the above task.
 */
import java.util.Scanner;

class FinancialCal {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.err.println("Pass three Command Line Arguments: principal , rate of intrest, time");
            System.exit(1);
        }
        int P = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        println("Your Entered Values:- Principal : " + P);
        println("Your Entered Values:- Rate Of Intesert : " + R);
        println("Your Entered Values:- Time : " + T);
        println("We taking values like this :-Principal Amount In Rupees , Rate of intrest in percentage, Time in Years");
        println("Press 1 for Simple Intrest.");
        println("Press 2 for Compound Intrest.");
        println("Press 3 for Final Value.:");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        CalIntrest Cai = new CalIntrest(P, R, T);
        if (input == 1) {
            println("Simple Intrest is: " + Cai.simpleIntrest());
        } else if (input == 2) {
            println("Input number of times interest is compounded per time period : ");
            int n = scan.nextInt();
            println("Simple Intrest is: " + Cai.coumpoundIntrest(n));
        } else if (input == 3) {
            println("Final value of Investment: " + Cai.finalValueInvest());
        } else {
            System.err.println("! Wrong Input.");
        }
    }

    static void println(Object line) {
        System.out.println(line);
    }
}

class CalIntrest {
    int p, r, t, n;

    public CalIntrest(int p, int r, int t) {
        this.p = p;
        this.r = r;
        this.t = t;
    }

    public double simpleIntrest() {
        double si1 = p * r * t;
        double si = si1 / 100;
        return si;
    }

    public double coumpoundIntrest(int n) {
        this.n = n;
        double cp = p * Math.pow((1 + r / n), n * t);
        return cp;
    }

    public double finalValueInvest() {
        return p * Math.pow(1 + r, t);
    }
}
