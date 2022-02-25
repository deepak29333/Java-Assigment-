/*Create a solution to know the address and name of your local machine?*/
import java.net.InetAddress;
import java.net.UnknownHostException;
class FP1{
    public static void main(String[] args) {
        InetAddress ip;
        String Hostname;
        try {
            ip=InetAddress.getLocalHost();
            Hostname =ip.getHostName();
           
            println(ip);
            println(Hostname);

        } catch (UnknownHostException e) {
            println("UnknownHostException "+e);
        }
    }
    public static void println(Object line){
        System.out.println(line);
    }
}

