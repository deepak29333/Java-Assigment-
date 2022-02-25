/*Create a calculator based client/server application where the client sends request to the 
server in the form of an arithmetic equation of the form “operand1 operator operator2”.
 The server should respond back to answer the equation?*/
 import java.net.*;
 import java.io.*;
 class FP5Server{
    private Socket socket=null;
    private ServerSocket server=null;
    private DataInputStream in =null;
    public FP5Server(int port){
        try {
            // Server makes a new Socket to communicate with the client
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            // accept() method blocks(just sits there) until a client connects to the server

            socket=server.accept();
            System.out.println("Client accepted");
            in =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out    = new DataOutputStream(socket.getOutputStream());
            //send data to client
            PrintStream ps = new PrintStream(socket.getOutputStream());
            String line="";
            String[] strAr;
            double output;
            while(!line.equals("over")){
                try {
                    line=in.readUTF();
                    // System.out.println(in.readUTF());
                        strAr=line.split(" ");
                        Double operator1= Double.parseDouble(strAr[0]); 
                        Double operator2= Double.parseDouble(strAr[2]); 
                        // System.out.println(operator1);

                    // ps.println(Integer.parseInt(strAr[0]));

                  switch(strAr[1]){
                      case "+":
                        output=operator1+operator2;
                        ps.println(output);
                        break;
                      case "-":
                        ps.println(operator1-operator2);
                        break;
                      case "*":
                        ps.println(operator1*operator2);
                        break;
                    case "/":
                        ps.println(operator1/operator2);
                        break;
                     default:
                        ps.println("Enter Correct Data in write Format");        
                  }
                } catch (Exception e) {
                   System.out.println("exception "+e);
                }
            }
        } catch (Exception e) {
            System.out.println("exception "+e);
        }
    }
    public static void main(String[] args) {
        FP5Server server=new FP5Server(5000);
    }
}