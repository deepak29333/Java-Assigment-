/*When user clicks the “Display” button the data entered by the user should
 be displayed in another frame window.
When user clicks the “Cancel” button the data fields should get cleared.*/
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import java.util.Scanner;
class ShowDataAwt extends Frame implements ActionListener {
    Label data;
    TextField text;
    TextField text1;
    TextArea textaddress;
    Button ok;
    ShowDataAwt(){
        //name label
        Label  name=new Label("name");
        add(name);
        name.setBounds(50,50,200,30);
        //date of joining label
        Label doj =new Label("Date Of Joinng");
        add(doj);
        doj.setBounds(50,100,200,30);
        //address label
        Label address= new Label("Address");
        address.setBounds(50, 150, 200, 30);
        add(address);

        //name text field
        text1=new TextField();
        text1.setBounds(300,50,100,30);
        add(text1);
        //date of joining textfield
        text =new TextField();
        text.setBounds(300,100,100,30); 
        add(text);
        //address textarea field
        textaddress=new TextArea();
        textaddress.setBounds(300,150,200,200);
        add(textaddress);
        
       //display button
        ok=new Button("Display");
        ok.setBounds(20,200,50,30);
        add(ok);
        // cancel button
        Button cancel= new Button("Cancel");
        add(cancel);
        cancel.setBounds(80,200,50,30);
        //form data display field
        data =new Label();
        data.setBounds(50,350,500,30);
        data.setBackground(Color.gray);
        add(data);
        //action on click on display button
        ok.addActionListener(this);  
        setSize(1300,700);
        setVisible(true);

        setLayout(null);
        //closing button code/close windows code
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }
    //button action
    public void actionPerformed(ActionEvent e){
            if(e.getSource()==ok){
                data.setText(
                    "Name: "+text1.getText()+
                    "  Date of JOining: "+ text.getText()+
                    "  address: "+textaddress.getText()
                );
                this.setVisible(true);
            }
    }
    
}

// using swing

class ShowDataSwing extends JFrame implements ActionListener {
    JLabel name;
    JLabel dateOJ;
    JLabel Address;
    JTextField nameTextField;
    JComboBox days;
    JComboBox Month;
    JComboBox year;
    JTextArea inputArea;
    JButton btnDisplay;
    JButton btnCancel;
    String totalday[]={"1","2","3","4","5","6","7","8","9","10"};
    String month[]={"jan","feb","march"};
    String years[]={"2000","2001"};
    ShowDataSwing(){
        //name label
        name=new JLabel("name");
        name.setBounds(50, 50, 200, 30);
        // add(name);
        // date of joining label
        dateOJ=new JLabel("Date Of Joining");
        dateOJ.setBounds(50,100,200,30);
        // add()
        // address lable
        Address =new JLabel("Address");
        Address.setBounds(50,150,200,30);
        // name textfield
        nameTextField = new JTextField();
        nameTextField.setBounds(300,50,200,30);
        //date of joining ComboBox
            // JComboBox cb=new JComboBox(country); 
            days=new JComboBox(totalday);
            days.setBounds(300, 100, 50, 30);   
            Month=new JComboBox(month);
            Month.setBounds(350, 100, 50, 30);
            year=new JComboBox(years);
            year.setBounds(400, 100, 50, 30);
            btnDisplay =new JButton("Display");
            btnCancel =new JButton("Cancel");
            btnDisplay.setBounds(20, 200,80, 30);
            btnCancel.setBounds(80, 200,80, 30);

        inputArea = new JTextArea();
        inputArea.setBounds(300, 150, 200, 300);
        add(name);
        add(dateOJ);
        add(Address);
        add(nameTextField);
        add(days);
        add(Month);
        add(year);
        add(inputArea);
        add(btnDisplay);
        add(btnDisplay);
        // day.setVisible(true);
        setLayout(null);
        setSize(1300,700);
        setVisible(true);
        revalidate();
        validate();
    }
    public void actionPerformed(ActionEvent e){

    }
}
class GP3{
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter 1 for AWT \nEnter 2 for Swing");
        try {
            int n=scan.nextInt();
            scan.close();
            if(n==1){
                new ShowDataAwt();
            }
            else{
               new  ShowDataSwing(); 
            }
        } catch (Exception e) {
           System.out.println("Execption Occure: "+e);
        }
       
    }
}