//Create a list of numbers and then sort in ascending order as well as in descending order simultaneously. 


import java.util.*;
class Numbers{
	public int result[] = new int[10];
	void displayListofNos()
	{
		System.out.println("Numbers stored in the array: ");
		for(int i=0;i<10;i++)
			System.out.print(result[i]+" ");
	}
	void fillArray(int upLimit, int size)
	{
		if(upLimit <= 0)
			throw new IllegalArgumentException(" UpperLimit must be positive: "+upLimit);
		if(size <= 0)
			throw new IllegalArgumentException("Size of returned list must be greater than 0.");
		Random gen = new Random();
		for(int i=0;i<size;i++)
		{
			result[i] = gen.nextInt(upLimit);
		}
		displayListofNos();
	}
	synchronized void sortAscending()
	{
		System.out.println("\n\nAfter sorting in ascending order");
		for (int i = 0; i < result.length; i++) {     
            for (int j = i+1; j < result.length; j++) {     
               if(result[i] > result[j]) {    
                   int temp = result[i];    
                   result[i] = result[j];    
                   result[j] = temp;    
               }     
            }     
        } 
		displayListofNos();
	}
	synchronized void sortDescending()
	{
		System.out.println("\n\nAfter sorting in descending order");
		for (int i = 0; i < result.length; i++) {     
            for (int j = i+1; j < result.length; j++) {     
               if(result[i] < result[j]) {    
                   int temp = result[i];    
                   result[i] = result[j];    
                   result[j] = temp;    
               }     
            }     
        }    
		displayListofNos();
	}
	
}
class ArrangeAscending implements Runnable
{
	Numbers n1;
	ArrangeAscending(Numbers n)
	{
		n1 = n;
		new Thread(this).start();
	}
	public void run()
	{
		n1.sortAscending();
	}
}
class ArrangeDescending implements Runnable
{
	Numbers n2;
	ArrangeDescending(Numbers n)
	{
		n2 = n;
		new Thread(this).start();
	}
	public void run()
	{
		n2.sortDescending();
	}
}
class DP10
{
	  public static void main(String[] args)
	  {
		Numbers n = new Numbers();
		n.fillArray(20,10);
		
		ArrangeAscending ac = new ArrangeAscending(n);
		Thread t1 = new Thread(ac);
		
		ArrangeDescending dc = new ArrangeDescending(n);
		Thread t2 = new Thread(dc);
	  }
}
