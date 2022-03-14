//Create a solution to know the address and name of your local machine?
import java.util.HashSet;
import java.util.Set;
class person{
	private int age;
	private String name;
	person(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	public String toString()
	{	return name + ": " + age;
	}
	 public boolean equals(Object o) {
      return o != null && o instanceof person && this.age == ((person)o).age;
   }
      public int hashCode() {
      return age;
   }
}
// class personmain
public class EP1{
	public static void main(String[] args)
	{
      person p=new person(21,"Deepak");
	  person p2=new person(30,"vishal");
	  person p1=new person(18,"Ankit");
	  person p3=new person(20,"Neha");
	 person p4=new person(22,"Aunchal");
	Set<person> s=new HashSet<person>();
     s.add(p);
	  s.add(p1);
	  s.add(p2);
	  s.add(p3);
	  s.add(p1);
	  s.add(p4);
	 System.out.println(s); 
   }
 }
