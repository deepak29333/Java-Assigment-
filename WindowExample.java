/*PQ. Create a Frame Window and close it on clicking the close button?*/
// importing necessary awt libraries   
import java.awt.*;    
import java.awt.event.*;    
    
  
// class which inherits the Frame class  
public class WindowExample extends Frame {    
// class constructor  
    WindowExample() {    
// adding WindowListener to the Frame  
// and using the windowClosing() method of WindowAdapter class  
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });    
// setting the size, layout and visibility of frame  
        setSize (400,400);    
        setLayout (null);    
        setVisible (true);    
    }    
// main method  
public static void main (String[] args) {    
    new WindowExample();    
}  }
