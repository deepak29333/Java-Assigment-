/*PQ1 Create a solution to understand the different parts of a URL?*/
// Java program to demonstrate working of URL 
import java.net.MalformedURLException; 
import java.net.URL; 
public class URLclass1 
{ public static void main(String[] args) throws MalformedURLException {
     // creates a URL with string representation. 
		URL url = new URL("https://www.youtube.com/watch?v=jS67A_pVR9M&ab_channel=ShekharJaiswal"); 
		// print the string representation of the URL. 
		System.out.println("URL:"+url.toString()); 
		System.out.println(); 
		System.out.println("Different components of the url-"); 
		// retrieve the protocol for the URL 
		System.out.println("Protocol:- " + url.getProtocol()); 
		// retrieve the hostname of the url 
		System.out.println("Hostname:- " + url.getHost()); 
		// retrieve the defalut port 
		System.out.println("Default port:- " + url.getDefaultPort()); 
		// retrieve the query part of URL 
		System.out.println("Query:- " + url.getQuery()); 
		// retrive the path of URL 
		System.out.println("Path:- " + url.getPath()); 
		// retrive the file name 
		System.out.println("File:- " + url.getFile()); 
		// retrieve the reference 
		System.out.println("Reference:- " + url.getRef()); 
	}
} 
