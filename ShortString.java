/*Develop a command line driven code to accept the following city name as argument in the command line and sort them in alphabetic 
order – City Name = Kolkata, Chennai, Mumbai, Delhi, Bangalore, Ahmedabad.*/
class ShortString{
    public static void main(String args[]){
        for(int i=0;i<args.length;i++){
            for(int j=i+1;j<args.length;j++){
                if(args[i].compareTo(args[j])>0){
                    String temp=args[j];
                    args[j]=args[i];
                    args[i]=temp;
                }
            }

        }
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
}