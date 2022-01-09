/* 
Use ragged array to provide the output given below (Take row count from user).
            1
            123
            1234
            12345
            123456
            1234567
            1
          12
        123
      1234
    12345
  123456
1234567

*/

class JaggedArray{
    public static void main(String[] args) {
        int n=7;
        // create 2d array 
        int[][] arr= new int[n][];
        for(int i=0;i<arr.length;i++){
            // creating subarray
            arr[i]=new int[i+1];
        }
        // initializing value to subarray
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j]=j+1;
            }
        }
        // printing subarray with with n spaces right angle at left side
        for(int i=0; i<arr.length; i++){
            print("       ");
            for(int j=0; j<arr[i].length; j++){
               print(arr[i][j]);
            }
            println("");
        }
        // printing second type 
        for(int i=0; i<arr.length; i++){
            String spaces="";
            for(int k=arr.length;k>i;k--){
                spaces=spaces+" ";
            } 
            print(spaces);
            for(int j=0; j<arr[i].length; j++){
               print(arr[i][j]);
            }
            println("");
        }
    }

    public static void  print(Object line) {
        System.out.print(line);
    }
    public static void  println(Object line) {
        System.out.println(line);
    }
}