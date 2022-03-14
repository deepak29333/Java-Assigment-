//Model AddressBookEntry that prints name,address and phone of a person. Allow comparison of AddressBookEntry to compare name in a case sensitive manner?
import java.util.*;

class AddressBook{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many persons have to add: ");
        int n = sc.nextInt();

        System.out.println("Enter name of "+ n +"  persons,");
        AddressBookEntry[] address = new AddressBookEntry[n];

        for(int i=0; i<n; i++){
            address[i] = new AddressBookEntry(sc.next());
        }

        TreeSet<AddressBookEntry> treeSet = new TreeSet<>(Arrays.asList(address));

        System.out.println("\nAddress Book Entries,");
        treeSet.forEach(v ->{
            System.out.println(v.name);
        });
		
        System.out.println("\n treeSet.floor: " + treeSet.floor(address[address.length/2]));
        System.out.println("\n treeSet.lower: " + treeSet.lower(address[address.length/2]));
        System.out.println("\n treeSet.headSet: " + treeSet.headSet(address[address.length/2]));
        System.out.println("\n treeSet.tailSet: " + treeSet.tailSet(address[address.length/2]));
    }
}

class AddressBookEntry implements Comparable<AddressBookEntry>{
    String name;

    public AddressBookEntry(String name){
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(AddressBookEntry o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    public boolean equals(Object o){
        return o instanceof AddressBookEntry && this.name.equalsIgnoreCase(((AddressBookEntry) o).name);
    }

    public int hashCode(){
        return name.toLowerCase().hashCode();
    }
}