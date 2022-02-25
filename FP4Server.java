import java.net.*;
import java.io.*;
// import java.lang.*;
public class FP4Server {
    private Socket socket=null;
    private ServerSocket server=null;
    private DataInputStream in =null;

    public FP4Server(int port, Employee[] empobj){
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
            while(!line.equals("10")){
                try {
                    line=in.readUTF();
                    boolean flag=false;
                    for (Employee emp : empobj) {
                        if(emp.getId()==Integer.parseInt(line)){
                            flag=true;
                            if(flag){
                                // out.writeUTF(emp.getData());
                                ps.println(emp.getData());
                                // System.out.println(emp.getData());
                                break;
                            }
                        }
                    }
                    if(!flag){
                        ps.println("Data Not Found");  
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
        Employee[] empobj =new Employee[3];
        empobj[0]=new Employee("Deepak",  1, "MCA");
        empobj[1]=new Employee("Ankit",  2, "MCA");
        empobj[2]=new Employee("Rohit",  3, "MCA");
        FP4Server server = new FP4Server(5000, empobj);
    }
}
class Employee {
    private String name;
    private int id;
    private String dept;
    public Employee(String name,int id, String dept){
        this.name=name;
        this.id=id;
        this.dept=dept;
    }
    public int getId(){
        return id;
    }
    public String getData(){
        return "Emp Name = "+name+" emp Id = " +id +" Emp Dep = "+dept;
    }
}
