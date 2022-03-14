//Create a Java application that executes concurrent transactions in a bank?
class Account
{
	public int balance;
	public int accNo;
	void displayBalance()
	{
		System.out.println("Account No: "+accNo+" Balance: "+balance);
	}
	synchronized void deposit(int amt)
	{
		balance += amt;
		System.out.println(amt+" is deposited");
		displayBalance();
	}
	synchronized void withdraw(int amt)
	{
		balance -= amt;
		System.out.println(amt+" is withdraw");
		displayBalance();
	}
}

class TransactionDeposit implements Runnable
{
	int amt;
	Account acc1;
	TransactionDeposit(Account a, int amt)
	{
		acc1 = a;
		this.amt = amt;
		new Thread(this).start();
	}
	public void run()
	{
		acc1.deposit(amt);
	}
}

class TransactionWithdraw implements Runnable
{
	int amt;
	Account acc2;
	TransactionWithdraw(Account a, int amt)
	{
		acc2 = a;
		this.amt = amt;
		new Thread(this).start();
	}
	public void run()
	{
		acc2.withdraw(amt);
	}
}
		
class DP9
{
	public static void main(String[] args)
	{
		Account acc = new Account();
		acc.balance = 1000;
		acc.accNo = 1234;
		TransactionDeposit t1;
		TransactionWithdraw t2;
		t1 = new TransactionDeposit(acc, 500);
		t2 = new TransactionWithdraw(acc, 900);
	}
		
}
