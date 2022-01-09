/*Create a package called animals,let this package contain an interface called Animal that generalizes the eat and travel task of any animal. Implement the given interface in the same package animals and override the methods appropriately?*/
package animals;
interface animal{
    String name="Dog";
    int travel=10; // in km
    void eat(String food);
    void travel();
}
class CP6 implements animal{
    public static void main(String[] args) {
      var O= new CP6();
      O.eat("Dog");
      O.travel();
    }
    public void eat(String food){
        System.out.println(animal.name+" can Eat milk");
    }
    public void travel(){
        System.out.println(animal.name+" can Travel "+animal.travel+"KM");
    }
}