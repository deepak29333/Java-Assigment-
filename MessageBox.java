/*Create a class MessageBox that extends Frame. The class should have a constructor that takes a String as a parameter to construct a dialog box that displays the message and OK & CANCEL buttons. The dialog box should get closed when the cancel buttons is clicked. Provide some mechanism in the MessageBox class that can be used by the calling program to check which button was pressed by the user. The class should have functions to:
a)	Check which button was pressed by the user.
b)	Retrieve the string entered by the user, if user pressed OK, null if user pressed CANCEL.
Test this class to get a message from a user and display it on a Frame window.*/
import javax.swing.*;
import java.awt.*;

public class MessageBox extends Frame {

    MessageBox(String str){
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(0,0, 200, 30);

        String[] options = {"OK", "Cancel"};
        int result = JOptionPane.showOptionDialog(
                frame,
                str,
                "Swing DialogBox",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //no custom icon
                options,  //button titles
                options[0] //default button
        );
        if(result == JOptionPane.YES_OPTION){
            label.setText("Pressed: OK");
        }else if (result == JOptionPane.NO_OPTION){
            label.setText("Pressed: Cancel");
        }else {
            label.setText("None Pressed!");
        }

        panel.add(label);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
       new MessageBox("Test String!");
    }
}
