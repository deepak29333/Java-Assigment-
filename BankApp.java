
/*Simulate a simple banking application. Provide for classes BankAccount. Account will be of two type- Savings and Current.
 There should be methods to open an account, close an account and perform withdraw, deposit and transfer operations on an
  account as abstract methods in Account and properly overridden with definition in Account Types. Test classes should
instantiate Account Type Classes and provide a menu driven option for operations.*/
import java.util.Scanner;

interface Account {
 void openaccount();

 void closeaccount();

 void withdraw(double amount);

 void deposit(double amount);
}

class SavingsAccount implements Account {
 static double balance;

 public void openaccount() {
  balance = 0.0;
  System.out.println("Account opened\nBalnace=" + balance);
 }

 public void closeaccount() {
  balance = 0.0;
  System.out.println("Account closed");
 }

 public void withdraw(double amount) {
  balance = 6000.0;
  if (amount <= balance) {
   balance = balance - amount;
   System.out.println("Balance after withdrawing " + amount + "=" + balance);
  } else {
   System.out.println("insufficient balance");
  }
 }

 public void deposit(double amount) {
  balance = 6000.0;
  balance = balance + amount;
  System.out.println("Balance after depositing " + amount + "=" + balance);
 }
}

class CurrentAccount implements Account {
 static double balance;

 public void openaccount() {
  balance = 0.0;
  System.out.println("Account opened\nBalnace=" + balance);
 }

 public void closeaccount() {
  balance = 0.0;
  System.out.println("Account closed");
 }

 public void withdraw(double amount) {
  balance = 5000;
  if (amount <= balance) {
   balance = balance - amount;
   System.out.println("Balance after withdrawing " + amount + "=" + balance);
  } else {
   System.out.println("insufficient balance:");
  }
 }

 public void deposit(double amount) {
  balance = 5000;
  balance = balance + amount;
  System.out.println("Balance after depositing " + amount + "=" + balance);
 }

}

public class BankApp {
 public static void main(String args[]) {
  Scanner s = new Scanner(System.in);
  char ch = 'y';
  do {
   System.out.println("Enter 1 for Savings Account and 2 for current account");
   int t = s.nextInt();
   switch (t) {
    case 1:
     SavingsAccount sa = new SavingsAccount();
     System.out.println(
       "Enter:\n1.for opening account\n2.for closing account\n3.for withdrawing money\n4.for depositing money\n");
     int choice = s.nextInt();
     switch (choice) {
      case 1:
       sa.openaccount();
       break;
      case 2:
       sa.closeaccount();
       break;
      case 3:
       System.out.println("Enter amount which you want to withdraw");
       int am = s.nextInt();
       sa.withdraw(am);
       break;
      case 4:
       System.out.println("Enter amount which you want to deposit");
       am = s.nextInt();
       sa.deposit(am);
       break;
      default:
       System.out.println("Wrong choice");
     }
     break;

    case 2:
     CurrentAccount ca = new CurrentAccount();

     System.out.println(
       "Enter:\n1.for opening account\n2.for closing account\n3.for withdrawing money\n4.for depositing money\n");
     choice = s.nextInt();
     switch (choice) {

      case 1:
       ca.openaccount();
       break;
      case 2:
       ca.closeaccount();
       break;
      case 3:
       ca.withdraw(1000.00);
       break;
      case 4:
       ca.deposit(2000.70);
       break;
      default:
       System.out.println("Wrong choice");

     }

     // default:System.out.println("Wrong choice");

   }

   System.out.println("Want to continue(Enter y)");
   ch = s.next().charAt(0);
  } while (ch == 'y' || ch == 'Y');

 }

}
