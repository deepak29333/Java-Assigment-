// GP4 b part
import javax.swing.*;
import java.awt.*;

public class DialogueBoxInput extends Frame {

    DialogueBoxInput(){
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(0,0, 400, 30);

        String result = (String)JOptionPane.showInputDialog(
                    frame,
                    "Enter Text",
                    "Swing Dialog Box",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    ""
        );

        if(result != null){
            label.setText("You Have Entered: " + result);
        }else {
            label.setText("Cancel Pressed, " + null);
        }

        panel.add(label);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
       new DialogueBoxInput();
    }
}
