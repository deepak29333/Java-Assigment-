/*Create a subclass of Person (in EP1 above), called ComparablePerson
 which implements Comparable<Person> interface, and try out the Collections.sort()
  and Collections.binarySearch() methods on the same.*/
  import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
class person{
	private int age;
	private String name;
	public person(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	public String getname() //getter for name
	{
		return name;
	}
	public String toString()
	{
		return name + ": " + age;
	}
}   
 class comparableperson extends person implements Comparable<person> { 
	public  comparableperson(int age1, String name1)
	{
		super(age1,name1);
	}
	public int compareTo(person p)
	{
		return this.getname().compareToIgnoreCase(p.getname());
	}
 }
 // comparemain
public	class EP2 {
	    public static void main(String[] args) {  
	comparableperson p=new comparableperson(23,"Deepak");
	 comparableperson p1=new comparableperson(20,"ankit");
	  comparableperson p2=new comparableperson(22,"Rohit");
	 comparableperson p3=new comparableperson(60,"Pankaj");
     List<comparableperson> li=new ArrayList<>();
	 li.add(p);
	 li.add(p1);
	 li.add(p2);
	 li.add(p3);
	Collections.sort(li);
	  System.out.println(li);	  
   System.out.println(Collections.binarySearch(li,new comparableperson(21,"vikash")));
   System.out.println(Collections.binarySearch(li,new comparableperson(10,"ishan")));
   }
 }