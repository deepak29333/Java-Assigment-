/*Create a class named GradeExam to grade a multiple choice test. There are 20 students and 10 questions in the test.
 Each row records a student’s answers to the questions, as shown in the following array: Grade the students according
  to their score in the test?*/
  import java.util.Random;
  class GradeExam{
      public static void main(String[] args) {
        
          char[][] record =new char[20][10];
          char[] options= {'a','b','c','d','e'}; 
          char[] answers={'d','b','d','c','c','d','a','e','a','d'}; 
          Random r=new Random();
          // assign Array element to index of 2 dimension array 
          for(int i=0;i<record.length;i++){
              for(int j=0; j<record[0].length;j++){
                  // Assign answet to question from options array
                  record[i][j]=options[r.nextInt(options.length)];
              }
          }
          printArray(record);
          printAnswerKey(answers);
          printGradeStudentWise(record,answers);
      }
        // print array elements
      static void printArray(char[][] arr){
        for(int i=0;i<arr.length;i++){
            print("Student Answers "+i+":  ");
            for(int j=0; j<arr[0].length;j++){
                print(arr[i][j]+" ");
            }
            println("");
        }
      }

      // display the Grade of student
      public static void printGradeStudentWise(char[][] arr, char[] answer){
        for(int i=0;i<arr.length;i++){
            int correctAnswer=0;
            print("Student Answers "+i+":  ");
            for(int j=0; j<arr[0].length;j++){
                print(arr[i][j]+" ");
                if(arr[i][j]==answer[j]){
                    correctAnswer++;
                }
            }
            println("Correct Answers/ Grade: "+correctAnswer+" ");
           
        }
      }
      public static void printAnswerKey(char[] answer){
        print(" Answer Key: ");
        for(int j=0; j<answer.length;j++){
            print(answer[j]+" ");
        }
        println("");
      }

      public static void println(Object line){
        System.out.println(line);
      }
      public static void print(Object line){
        System.out.print(line);
      }
  }
  