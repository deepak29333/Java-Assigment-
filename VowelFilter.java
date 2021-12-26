/*Define a class named VowelFilter which contains a static method named filterVowel().
 This method receives a character array as argument and returns another array which contains only
  the non-vowel characters of the argument array.*/
  class VowelFilter{
      public static void main(String[] args){
          char[] arr ={'a','b','c','d','e','f','g','h','i','j'};
          println("Array elements:-");
          printArray(arr);
          println("Filtered Array is:");
          printArray(filterVowel(arr));
            
      }
      static void println(Object line){
          System.out.println(line);
      }
      static void print(Object line){
        System.out.print(line);
        }
        // print array element
      static void printArray(char[] arr){
          for(int i=0;i<arr.length;i++){
              print(arr[i]+" ");
          }
          println("");
      }
      // filter vowels 
      static char[] filterVowel(char[] arr){
          char filterArr[]=new char[arr.length];
          int p=0;
          for(int i=0;i<arr.length;i++){
            if(arr[i]=='a' ||arr[i]=='e' ||arr[i]=='o' || arr[i]=='i' ||arr[i]=='u' ){
                continue;
            }
            else{
                filterArr[p]=arr[i];
                p++; 
            }
        }
        return filterArr;
      }

  }
  
