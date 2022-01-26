import java.util.*;
class ArrayListP {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        println("size of array list before add Element: " + arr.size());
        arr.add(34);
        arr.add(89);
        arr.add(12);
        arr.add(47);
        arr.add(15);
        arr.add(1, 0);
        println("size of array list After add Element: " + arr.size());
        println(arr);
        println(arr.get(2));
        // get the array
        // get the array
        Integer arr1[] = new Integer[arr.size()];
        arr1 = arr.toArray(arr1);

        println(arr1);

    }

    public static void println(Object line) {
        System.out.println(line);
    }
}