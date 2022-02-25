/*Create a class AWTCounter that starts a counter from 0 and increments its value on every button click?*/
import java.awt.*;
import java.awt.event.*;
// import java.util.EventListener;

class AWTCounter extends Frame implements ActionListener {
    private Label labelCount;
    private TextField tfCount;
    private Button ctButton;
    private int count;
   AWTCounter(){
    addWindowListener (new WindowAdapter() {    
        public void windowClosing (WindowEvent e) {    
            dispose();    
        }    
    });
       setSize(400,400);
       setLayout(new FlowLayout());
       setVisible(true);
       //ads label
       labelCount=new Label("Counter");
       add(labelCount);
       // add textFirld
       tfCount=new TextField(count+"",10);
       tfCount.setEditable(false);
       add(tfCount);
    // add button
    ctButton=new Button("Count");
    add(ctButton);
    // BtnCountListener btnListner= new BtnCountListener();
    ctButton.addActionListener(this);
    setTitle("Awt Counter");
   

   }
   public void actionPerformed(ActionEvent evt){
    ++count;
    tfCount.setText(count +"");
    }
   
}

class GP2{
    public static void main(String[] args) {
        new AWTCounter();
    }
}
