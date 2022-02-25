// import java.time.format.DateTimeFormatter;  
import java.net.*; 
import java.util.Scanner;
class FP3Client{
   public static int serverPort=3902;
   public static DatagramSocket ds;
    public static void main(String[] args) throws Exception{
        System.out.println("Client  Strted..");
        System.out.println("Enter Date Format: ");
        var scan =new Scanner(System.in);
        while(true){
            ds = new DatagramSocket();
            String str=scan.nextLine();
            if(str=="exit"){
                System.exit(0);
            }
            DatagramPacket p = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getLocalHost(),serverPort); 
            ds.send(p);     
        }
      // println(p);
      // printing the data which has been sent by the server 
    //   println(new String(p.getData(), 0, p.getLength())); 
    }
}