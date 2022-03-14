/*Use AWT /Swings to develop a Contact Manager. The GUI application 
maintains a simple list of contacts storing contact name and number.
 It provides basic features of CRUD (Create, Update, Retrieve and Delete) as
  per user choice. The application also supports search feature.*/
import javax.swing.*;  
import java.awt.event.*;
import java.util.ArrayList;

class Contact{
    private String Name, Mobile;
    Contact(String Name, String Mobile){
        this.Name = Name;
        this.Mobile = Mobile;
    }
    public String toString(){
        return Name+ " "+ Mobile;
    }
    public String getName(){
        return this.Name;
    }
}

public class GP5 {

    ArrayList<Contact> ContactList = new ArrayList<>();

    public GP5(){

        JFrame f=new JFrame(); 
        
        f.setSize(350,350); 
        f.setLayout(null); 
        f.setVisible(true); 
        f.setTitle("Contact Manager");
        f.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                f.dispose();    
            }    
        });

        JLabel lbl = new JLabel("Contact Manager App");
        lbl.setBounds(100, 60, 150, 30);
        JButton c = new JButton("Create");  
        c.setBounds(60, 120, 100, 30);
        JButton r = new JButton("Retrieve");  
        r.setBounds(170, 120, 100, 30);
        JButton u = new JButton("Update");  
        u.setBounds(60, 160, 100, 30);
        JButton d = new JButton("Delete");  
        d.setBounds(170, 160, 100, 30);  
        JButton all = new JButton("Display all Contacts");  
        all.setBounds(65, 200, 200, 30);  
        f.add(lbl);    f.add(c);  f.add(r);    f.add(u);   f.add(d);   f.add(all);
        
        c.addActionListener ( 
            new ActionListener() {  
                public void actionPerformed( ActionEvent e ) {
                    JFrame f=new JFrame(); 
                    f.setSize(300,300); 
                    f.setLayout(null); 
                    f.setVisible(true); 
                    f.setTitle("Create");
                    f.addWindowListener (new WindowAdapter() {    
                        public void windowClosing (WindowEvent e) {    
                            f.dispose();    
                        }    
                    });

                    JLabel name = new JLabel("Name: ");
                    name.setBounds(20, 70, 70, 30);
                    JLabel mobile = new JLabel("Mobile No: ");
                    mobile.setBounds(20, 110, 70, 30);
                    JTextField nameTF = new JTextField();
                    nameTF.setBounds(100, 70, 100, 30);
                    JTextField mobileTF = new JTextField();
                    mobileTF.setBounds(100, 110, 100, 30);
                    JButton sbmt = new JButton("Submit");
                    sbmt.setBounds(70, 150, 120, 30);
                    f.add(name); f.add(mobile); f.add(nameTF); f.add(mobileTF); f.add(sbmt);

                    sbmt.addActionListener ( 
                        new ActionListener() {  
                            public void actionPerformed( ActionEvent e ) {
                                ContactList.add(new Contact(nameTF.getText(), mobileTF.getText()));
                                f.dispose();
                            }   
                       }
                    );  
                }   
            }
        );

        r.addActionListener ( 
            new ActionListener() {  
                public void actionPerformed( ActionEvent e ) {
                    JFrame f=new JFrame(); 
                    f.setSize(300,300); 
                    f.setLayout(null); 
                    f.setVisible(true); 
                    f.setTitle("Retrieve");
                    f.addWindowListener (new WindowAdapter() {    
                        public void windowClosing (WindowEvent e) {    
                            f.dispose();    
                        }    
                    });
                }   
            }
        );

        u.addActionListener ( 
            new ActionListener() {  
                public void actionPerformed( ActionEvent e ) {
                    JFrame f=new JFrame(); 
                    f.setSize(300,300); 
                    f.setLayout(null); 
                    f.setVisible(true); 
                    f.setTitle("Update");
                    f.addWindowListener (new WindowAdapter() {    
                        public void windowClosing (WindowEvent e) {    
                            f.dispose();    
                        }    
                    });
                }   
            }
        );

        d.addActionListener ( 
            new ActionListener() {  
                public void actionPerformed( ActionEvent e ) {
                    JFrame f=new JFrame(); 
                    f.setSize(300,300); 
                    f.setLayout(null); 
                    f.setVisible(true); 
                    f.setTitle("Delete");
                    f.addWindowListener (new WindowAdapter() {    
                        public void windowClosing (WindowEvent e) {    
                            f.dispose();    
                        }    
                    });
                    JLabel lbl = new JLabel("Enter the Contact name to delete: ");
                    lbl.setBounds(20, 50, 150, 30);
                    JTextField TF = new JTextField();
                    TF.setBounds(40, 90, 70, 30);
                    JButton dl = new JButton("Delete Contact");
                    dl.setBounds(60, 130, 80, 30);
                    f.add(lbl); f.add(TF); f.add(dl);
                }   
            }
        );

        all.addActionListener ( 
            new ActionListener() {  
                public void actionPerformed( ActionEvent e ) {
                    JFrame f=new JFrame(); 
                    f.setSize(300,300); 
                    f.setLayout(null); 
                    f.setVisible(true); 
                    f.setTitle("Contact List");
                    f.addWindowListener (new WindowAdapter() {    
                        public void windowClosing (WindowEvent e) {    
                            f.dispose();    
                        }    
                    });           
                    for (int i=0; i<ContactList.size(); i++) {
                        JLabel dl = new JLabel((ContactList.get(i)).toString());
                        dl.setBounds(20, 80+i*20, 100, 15); 
                        f.add(dl);
                    }
                }   
            }  );
    }
        
    public static void main(String[] args) {
        new GP5();
    }  
}