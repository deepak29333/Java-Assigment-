
import java.net.*;
import java.io.*;
public class FP5Client {
    private Socket socket            = null;
    private BufferedReader  input   = null;
    private DataOutputStream out     = null;
    private DataInputStream in =null;
    public FP5Client(int port){
         // establish a connection
         try
         {
             socket = new Socket(InetAddress.getLocalHost(), port);
             System.out.println("Connected");
  
             // takes input from terminal
             input  = new BufferedReader(new InputStreamReader(System.in));
             // sends output to the socket
             out    = new DataOutputStream(socket.getOutputStream());
             BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
             String line="";
             String output="";
             while(!line.equals("over")){
                try {
                    line = input.readLine();
                    // System.out.println(line);
                    out.writeUTF(line);
                    
                    // receive from the server
                    output = br.readLine();
                        System.out.println(output);
                    // output=in.readUTF();
                    // System.out.println(output);

                } catch (Exception e) {
                   System.out.println("exception "+e);
                }
            }
         }
         catch(UnknownHostException u)
         {
             System.out.println(u);
         }
         catch(IOException i)
         {
             System.out.println(i);
         }
    }

    public static void main(String[] args) {
        FP5Client  server =new FP5Client(5000);
    }
}

