
/*
 * Develop an employee pay generator that works on the following rules-
 * 
 * 1. An employee gets paid (hours worked) × (base pay), for each hour up to
 * 40hours.
 * 2. For every hour over 40, they get overtime = (base pay) ×1.5.
 * 
 * 3. The base pay must not be less than the minimum wage ($8.00 an hour).
 * 
 * 4. If it is, print an error. If the number of hours is greater than 60, print
 * an error message.
 */
import java.util.Scanner;

class EmployeePay {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        println("Note:- Total Hours Should be greater than 8 and less than 60: ");
        println("Enter Total Hours Employee: ");
        int hours = scan.nextInt();
        println("Enter Base Pay Of Employee: $");
        int basePay = scan.nextInt();
        scan.close();
        EmployeePayValidate vali = new EmployeePayValidate(hours, basePay);
        if (vali.inputValidate()) {
            System.err.println("! Wrong Input");
            System.exit(1);

        }
        BasePay p = new BasePay(hours, basePay);
        if (hours <= 40) {
            totalPaySms();
            println(p.Upto40());
        } else {
            totalPaySms();
            println(p.Above40());
        }
    }

    static void println(Object line) {
        System.out.println(line);
    }

    static void print(Object line) {
        System.out.print(line);
    }

    static void totalPaySms() {
        print("Total Paid of Employee: $");
    }
}

class BasePay {
    int basePay;
    int total_hour;

    public BasePay(int hours, int basePay) {
        this.total_hour = hours;
        this.basePay = basePay;
    }

    public int Upto40() {
        return total_hour * basePay;
    }

    public double Above40() {
        double extrapay = (total_hour - 40) * basePay * 1.5;
        return Upto40() + extrapay;
    }
}

class EmployeePayValidate {
    int hours, basePay;

    public EmployeePayValidate(int hours, int basePay) {
        this.hours = hours;
        this.basePay = basePay;
    }

    public boolean inputValidate() {
        if (hours < 8 || hours > 60) {
            return true;
        }
        return false;
    }
}