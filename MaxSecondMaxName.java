
/*A group of BVICAM friends decide to run the Airtel Delhi Half Marathon. Their names and times (in minutes) are below:
Name               Time (minutes)
 Elena                       341
Thomas                    273
Hamilton                 278
Suzie                         329
Phil                            445
Matt                           402
Alex                           388
Emma                        275
John                           243
James                         334
Jane                            412
Find the fastest runner. Print the name and his/her time (in minutes).
Optional: Find the second fastest runner. Print the name and his/her time (in minutes).*/

class MaxSecondMaxName {
    public static void main(String args[]) {
        String Student_name[] = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John",
                "James", "Jane" };
        int Student_time[] = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412 };
  
    int fastest = maxIndex(Student_time);
    int secondFast = secondMax(Student_time,fastest);
    println("Fastest Runnder is: "+ Student_name[fastest]+" Time: "+Student_time[fastest]);
    println("Second Fastest Runnder is: "+ Student_name[secondFast]+" Time: "+Student_time[secondFast]);
    
 }
 static void println(Object line) {
    System.out.println(line);
}
    static int maxIndex(int[] arr) {
        int maxIndex = 0;
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < maxVal) {// fastest runner which is taking less time
                maxVal=arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int secondMax(int[] arr, int maxEleIndex) {
        int SecMaxIndex = 0;
        int SecMaxVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i != maxEleIndex) { // avoid first fastest
                if (arr[i] < SecMaxVal) { // second fastest runner which is taking less time
                    SecMaxVal=arr[i];
                    SecMaxIndex = i;
                }
            }

        }
        return SecMaxIndex;
    }

}