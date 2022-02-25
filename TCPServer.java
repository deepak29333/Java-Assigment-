/*Create a solution to create a simple TCP/IP client-server where the server displays the message from the client till the client types “Over”?*/
// A Java program for a Server
import java.net.*;
import java.io.*;
public class TCPServer
{//initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    // constructor with port
    public TCPServer(int port)
    {   // starts server and waits for a connection
        try
        {	// Server makes a new Socket to communicate with the client
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
			// accept() method blocks(just sits there) until a client connects to the server
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket using getInputStream() method
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
 
            String line = "";
 
            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {try
                {line = in.readUTF();
                    System.out.println(line);
 
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
		//Server listening for client requests coming in for port 5000
        TCPServer server = new TCPServer(5000);
    }
}
