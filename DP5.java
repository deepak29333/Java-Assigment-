
/*Extend CP5 (Bank application)with appropriate exception handling?

*/
import java.util.*;
interface Account
{
	public void openAccount(int a);
	public void closeAccount(int a);
	public void deposite();
	public void withdrawn(int a);
	public void transfer(int a1,int a2);
}
class InsufficientBalanceException extends Exception
{
	InsufficientBalanceException(String s)
	{
		super(s);
	}
}
class InvalidAccountException extends Exception
{
	InvalidAccountException(String s)
	{
		super(s);
	}
}
class Savings implements Account
{
	ArrayList<Integer> ob= new ArrayList<Integer>();
	ArrayList<Double> de= new ArrayList<Double>();
	Scanner sc=new Scanner(System.in);
	public void openAccount(int a)
	{
		try{
		ob.add(a);
		de.add(0.0);
		System.out.println("Savings Account number: "+a+" Successfully opened");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void closeAccount(int a)
	{
		try{
		if(ob.contains(a))
		{
			ob.remove(a);
			System.out.println("Savings Account no.:"+a+" Successfully closed");
		}
			else
				throw new InvalidAccountException("No such Account exits");
				//System.out.println("No such account number exits to remove");
		}
		catch(InvalidAccountException e)
		{
			System.out.println(e);
		}
		
	}
	
	public void deposite()
	{
		try{
		double amt;
		int a,f=0;
		
		System.out.println("Enter the account no. in which you want to deposite");
		a=sc.nextInt();
			if(ob.contains(a))
			{
			System.out.println("Enter the amount you want to deposite:");
			amt=sc.nextDouble();

			double q=de.get(ob.indexOf(a))+amt;
			de.set(ob.indexOf(a),q);
			
			System.out.println(amt+" rupees successfully deposited in your account,your new balance is:"+de.get(ob.indexOf(a)));
			}
		
		else
			System.out.println("No such account exits, Enter correct account number");
		}
		catch(Exception e)
		{
			System.out.println(e+" Enter valid amount");
		}
	}
	public void withdrawn(int a)
	{
		double amt;
		
		try{
			if(ob.contains(a))
			{
			System.out.println("Your current balance is:"+de.get(ob.indexOf(a)));
			System.out.println("Enter the amount you want to withdraw:");
			amt=sc.nextDouble();
			if(amt>de.get(ob.indexOf(a)))
			System.out.println("Insufficient balance");
			else
			{
				if(de.get(ob.indexOf(a))<=100)
					throw new InsufficientBalanceException("Your account balance cannot be less than 100");
				else
				{
				de.set(ob.indexOf(a),de.get(ob.indexOf(a))-amt);
				System.out.println("Your new balance is:"+de.get(ob.indexOf(a)));
				}
			}
			}
			else
			System.out.println("No such account exits, Enter correct account number");
		}
		catch(InsufficientBalanceException e)
					{
						System.out.println(e);
					}
	}
	public void transfer(int a1,int a2)
	{
				System.out.println("Enter the amount that want to transfer");
				double amt=sc.nextDouble();
		if(a1==a2)
		{
			System.out.println("You cannot transfer to your own account");
		}
		if(ob.contains(a1)&&ob.contains(a2))
		{

			if(amt>de.get(ob.indexOf(a1)))
			System.out.println("Insufficient balance");
		
		
		else
		{
			try{
					if(de.get(ob.indexOf(a1))<=100)
					throw new InsufficientBalanceException("Your account balance cannot be less than 100");
			else{
			System.out.println("Balance of account no. "+a1+" and account no. "+a2+" before trasfer is:"+de.get(ob.indexOf(a1))+" and "+de.get(ob.indexOf(a2)));
			de.set(ob.indexOf(a1),de.get(ob.indexOf(a1))-amt);
			de.set(ob.indexOf(a2),de.get(ob.indexOf(a2))+amt);
			System.out.println("Transfer successfull new balance of account number: "+a1+" is "+de.get(ob.indexOf(a1))+" and of account number "+a2+" is:"+de.get(ob.indexOf(a2)));
			}
		}
		
		catch(InsufficientBalanceException e)
					{
						System.out.println(e);
					}
		}
		
		}
		
		
			else
			System.out.println("No such account exits, Enter correct account number");	
	}
	
}
	
			
		
		

class Current implements Account
{
	ArrayList<Integer> ob= new ArrayList<Integer>();
	ArrayList<Double> de= new ArrayList<Double>();
	Scanner sc=new Scanner(System.in);
	public void openAccount(int a)
	{
		ob.add(a);
		de.add(0.0);
		System.out.println("Savings Account number: "+a+" Successfully opened");
	}
	public void closeAccount(int a)
	{
		try{
		if(ob.contains(a))
		{
			ob.remove(a);
			System.out.println("Savings Account no.:"+a+" Successfully closed");
		}
			else
			throw new InvalidAccountException("No such Account exits");	
			//System.out.println("No such account number exits to remove");
		}
		catch(InvalidAccountException e)
		{
			System.out.println(e);
		}
	}
	
	public void deposite()
	{
		double amt;
		int a,f=0;
		
		System.out.println("Enter the account no. in which you want to deposite");
		a=sc.nextInt();
			if(ob.contains(a))
			{
			System.out.println("Enter the amount you want to deposite:");
			amt=sc.nextDouble();

			double q=de.get(ob.indexOf(a))+amt;
			de.set(ob.indexOf(a),q);
			
			System.out.println(amt+" rupees successfully deposited in your account,your new balance is:"+de.get(ob.indexOf(a)));
			}
		
		else
			System.out.println("No such account exits, Enter correct account number");
	}
	public void withdrawn(int a)
	{
		double amt;
		
			if(ob.contains(a))
			{
			System.out.println("Your current balance is:"+de.get(ob.indexOf(a)));
			System.out.println("Enter the amount you want to withdraw:");
			amt=sc.nextDouble();
			if(amt>de.get(ob.indexOf(a)))
			System.out.println("Insufficient balance");
			else
			{
				de.set(ob.indexOf(a),de.get(ob.indexOf(a))-amt);
				System.out.println("Your new balance is:"+de.get(ob.indexOf(a)));
			}
			}
			else
			System.out.println("No such account exits, Enter correct account number");
	}
	public void transfer(int a1,int a2)
	{
				System.out.println("Enter the amount that want to transfer");
				double amt=sc.nextDouble();
				
				System.out.println("yes");
		if(a1==a2)
		{
			System.out.println("You cannot transfer to your own account");
		}
		
		else if(ob.contains(a1) && ob.contains(a2))
		{
				System.out.println("fg");
			if(amt>de.get(ob.indexOf(a1)))
			System.out.println("Insufficient balance");
			else
			{
			System.out.println("Balance of account no. "+a1+" and account no. "+a2+" before trasfer is:"+de.get(ob.indexOf(a1))+" and "+de.get(ob.indexOf(a2)));
			de.set(ob.indexOf(a1),de.get(ob.indexOf(a1))-amt);
			de.set(ob.indexOf(a2),de.get(ob.indexOf(a2))+amt);
			System.out.println("Transfer successfull new balance of account number: "+a1+" is "+de.get(ob.indexOf(a1))+" and of account number "+a2+" is:"+de.get(ob.indexOf(a2)));
			}
		}
		else
		System.out.println("No such account exits, Enter correct account number");
				
	}
	
}
	
		
public class DP5
{
	public static void main(String args[])
	{
		Savings s=new Savings();
		Current c=new Current();
		int ch,x,x1;
		Scanner sc=new Scanner(System.in);
		do
		{
		System.out.println("Enter 1 for savings account\nEnter 2 for Current account\nEnter 0 to exit\nEnter your choice:");
		ch=sc.nextInt();
		switch(ch)
		{
			case 0:System.exit(0);
					break;
			case 1:
			do{
				
				System.out.println("Enter 1 to open new account\nEnter 2 to close an account\nEnter 3 to deposite money\nEnter 4 to withdraw money\nEnter 5 to tranfer money\nEnter 0 to exit\n Enter your choice");
				x=sc.nextInt();
				if(x==1)
				{
					try{
					System.out.println("Enter account no");
					int a=sc.nextInt();
					s.openAccount(a);
					}
					catch(Exception e)
					{
						System.out.println(e+" Enter valid Account number");
					}
				}
				else if(x==2)
				{
					System.out.println("Enter account no");
					int a=sc.nextInt();
					s.closeAccount(a);
				}
				else if(x==3)
				{
					
					s.deposite();
				}
				else if(x==4)
				{
					
					System.out.println("Enter account no");
					int a=sc.nextInt();
					s.withdrawn(a);
					
					
				}
				else if(x==5)
				{
					System.out.println("Enter account no from which you want to transfer:");
					int a1=sc.nextInt();
					System.out.println("Enter account no to which you want to trasfer:");
					int a2=sc.nextInt();
					s.transfer(a1,a2);
					
				}
			}while(x!=0);
			break;
			case 2:
			do{
				System.out.println("Enter 1 to open new account\nEnter 2 to close an account\nEnter 3 to deposite money\nEnter 4 to withdraw money\nEnter 5 to tranfer money\nEnter 0 to exit\n Enter your choice");
				x1=sc.nextInt();
				if(x1==1)
				{
					System.out.println("Enter account no");
					int a=sc.nextInt();
					c.openAccount(a);
				}
				else if(x1==2)
				{
					System.out.println("Enter account no");
					int a=sc.nextInt();
					c.closeAccount(a);
				}
				else if(x1==3)
				{
					
					c.deposite();
				}
				else if(x1==4)
				{
					System.out.println("Enter account no");
					int a=sc.nextInt();
					c.withdrawn(a);
				}
				else if(x1==5)
				{
					System.out.println("Enter account no from which you want to transfer:");
					int a1=sc.nextInt();
					System.out.println("Enter account no to which you want to trasfer:");
					int a2=sc.nextInt();
					c.transfer(a1,a2);
					
				}
			}while(x1!=0);
			break;
		}
		}while(ch!=0);
				
		}
}