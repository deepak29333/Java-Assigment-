import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.MouseInfo;

//new class that implements MouseListener interface
public class JMouseListenerExample implements MouseListener
{//create two labels lbl1 and lbl2
Label lbl1, lbl2;
//create a frame fr
Frame fr;
//create a sing s
String s;
JMouseListenerExample()
{fr = new Frame("Java Mouse Listener Example");
lbl1= new Label("Demo for the mouse event", Label.CENTER);
lbl2= new Label();
//set the layout of frame as flowlayout
fr.setLayout(new FlowLayout());
//add label 1 to frame
fr.add(lbl1);
//add label 2 to frame
fr.add(lbl2);
//In order to catch as evll as respond to the mouse events, register the created class JMouseListenerExample
fr.addMouseListener(this);
//set the size of frame where width is 350 and height is 220
fr.setSize(350,220);
//set the visibility of frame as true
fr.setVisible(true);}
//implementation of mouseClicked method
public void mouseClicked(MouseEvent ev)
{s+=" then, the mouse button is clicked";
//set the text of label 2 as s
lbl2.setText(s);
//set the visibility as true
fr.setVisible(true);}
//implementation of mouseEntered method
public void mouseEntered(MouseEvent ev)
{//set the text of label 2 when mouse enters
lbl2.setText("Now, the mouse has entered the area of window");
//set the visibility as true
fr.setVisible(true);}
//implementation of mouseExited method
public void mouseExited(MouseEvent ev)
{
//set the text of label 2 when the mouse leaves the window
lbl2.setText("Mouse has left the area of window");
//set the visibility as true
fr.setVisible(true);
}//implementation of mousePressed method
public void mousePressed(MouseEvent ev)
{//set the text of label 2 when the mouse is pressed
lbl2.setText("Mouse button pressed At "+MouseInfo.getPointerInfo().getLocation().x+ ","+MouseInfo.getPointerInfo().getLocation().y);
//set the visibility as true
fr.setVisible(true);}
//implementation of mouseReleased method
public void mouseReleased(MouseEvent ev)
{//set the string s
s="Firstly, the mouse button is released and ";
//set the text of label 2
lbl2.setText(s);
//set the visibility as true
fr.setVisible(true);}
//main method
    public static void main(String args[])
    {
        new JMouseListenerExample();
    }
}
