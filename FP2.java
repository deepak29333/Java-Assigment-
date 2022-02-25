/*Create a solution to understand the different components of a URL?*/

import java.net.MalformedURLException; 
import java.net.URL; 
public class FP2 
{ public static void main(String[] args) throws MalformedURLException {
     // creates a URL with string representation. 
		URL url = new URL("https://www.youtube.com/watch?v=jS67A_pVR9M&ab_channel=ShekharJaiswal"); 
		// print the string representation of the URL. 
		println("URL:"+url.toString()); 
		println(""); 
		println("Different components of the url-"); 
		// retrieve the protocol for the URL 
		println("Protocol:- " + url.getProtocol()); 
		// retrieve the hostname of the url 
		println("Hostname:- " + url.getHost()); 
		// retrieve the defalut port 
		println("Default port:- " + url.getDefaultPort()); 
		// retrieve the query part of URL 
		println("Query:- " + url.getQuery()); 
		// retrive the path of URL 
		println("Path:- " + url.getPath()); 
		// retrive the file name 
		println("File:- " + url.getFile()); 
		// retrieve the reference 
		println("Reference:- " + url.getRef()); 
	}
    public static void println(Object line){
        System.out.println(line);
    }
} 
