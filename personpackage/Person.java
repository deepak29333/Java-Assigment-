/*Create a package personpackage. This package contains a class Person with data members to represent firstName and lastName
 of a person and appropriate methods to read and display the same. Define appropriate class to test the above class outside
  the above package?*/
  //part 1 CP7
  package personpackage;
  public class Person{
      public String first_name;
      public String lastname;
      public void setFirstName(String f_name){
        this.first_name=f_name;
      }
      public void setLastName(String L_name){
        this.lastname=L_name;
      }
      public String getFirstName(){
          return this.first_name;
      }
      public String getLastName(){
        return this.lastname;
    }
  }