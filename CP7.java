/*Create a package personpackage. This package contains a class Person with data members to represent firstName and lastName
 of a person and appropriate methods to read and display the same. Define appropriate class to test the above class outside
  the above package?*/
  //part 1 CP7
  import personpackage.*;
  class CP7{
        public static void main(String[] args) {
            Person p=new Person();
            p.setFirstName("Deepak");
            p.setLastName("kumar");
            System.out.println("person full name is: "+p.getFirstName()+" "+p.getLastName());
        }
  }