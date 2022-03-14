/*Create a class MyTextEditor to simulate a notepad using Swings?*/
import java.io.File;
import java.util.Objects;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFileFilter extends FileFilter
{
    private String extension;
    private String description;

    public MyFileFilter(final String ext, final String desc)
    {
        setExtension(ext);
        setDescription(desc);
    }

    public boolean accept(File f)
    {
        final String filename=f.getName();

        return f.isDirectory() ||
                extension == null ||
                filename.toUpperCase()
                        .endsWith(extension.toUpperCase());

    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String desc)
    {
        description = Objects.requireNonNullElse(desc, "All Files(*.*)");
    }

    public void setExtension(String ext)
    {
        if(ext==null)
        {extension=null;  return;}

        extension= ext.toLowerCase();
        if(!ext.startsWith("."))
            extension="."+extension;
    }
}




class FileOperation
{
    MYTextEditor npd;
    boolean saved;
    boolean newFileFlag;
    String fileName;
    String applicationTitle="Notepad";

    File fileRef;
    JFileChooser chooser;

    FileOperation(MYTextEditor npd)
    {
        this.npd=npd;

        saved=true;
        newFileFlag=true;
        fileName= "Untitled";
        fileRef=new File(fileName);
        this.npd.f.setTitle(applicationTitle);

        chooser=new JFileChooser();
        chooser.addChoosableFileFilter(new MyFileFilter(".java","Java Source Files(*.java)"));
        chooser.addChoosableFileFilter(new MyFileFilter(".txt","Text Files(*.txt)"));
        chooser.setCurrentDirectory(new File("."));

    }

    boolean saveFile(File temp)
    {
        try (FileWriter fout = new FileWriter(temp)) {
            fout.write(npd.ta.getText());
        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        }
        updateStatus(temp,true);
        return true;
    }

    void saveThisFile()
    {

        if(!newFileFlag)
        {
            saveFile(fileRef);
            return;}

        saveAsFile();
    }

    boolean saveAsFile()
    {
        File temp;
        chooser.setDialogTitle("Save As...");
        chooser.setApproveButtonText("Save Now");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_S);
        chooser.setApproveButtonToolTipText("Click me to save!");

        do
        {
            if(chooser.showSaveDialog(this.npd.f)!=JFileChooser.APPROVE_OPTION)
                return false;
            temp=chooser.getSelectedFile();
            if(!temp.exists()) break;
            if(   JOptionPane.showConfirmDialog(
                    this.npd.f,"<html>"+temp.getPath()+" already exists.<br>Do you want to replace it?<html>",
                    "Save As",JOptionPane.YES_NO_OPTION
            )==JOptionPane.YES_OPTION)
                break;
        }while(true);


        return saveFile(temp);
    }

    boolean openFile(File temp)
    {

        try (FileInputStream fin = new FileInputStream(temp); BufferedReader din = new BufferedReader(new InputStreamReader(fin))) {
            String str;
            while (true) {
                str = din.readLine();
                if (str == null)
                    break;
                this.npd.ta.append(str + "\n");
            }

        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        }atus(temp,true);
        this.npd.ta.setCaretPosition(0);
        return true;
    }

    void openFile()
    {
        if(!confirmSave()) return;
        chooser.setDialogTitle("Open File...");
        chooser.setApproveButtonText("Open this");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
        chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

        File temp;
        do
        {
            if(chooser.showOpenDialog(this.npd.f)!=JFileChooser.APPROVE_OPTION)
                return;
            temp=chooser.getSelectedFile();

            if(temp.exists())	break;

            JOptionPane.showMessageDialog(this.npd.f,
                    "<html>"+temp.getName()+"<br>file not found.<br>"+
                            "Please verify the correct file name was given.<html>",
                    "Open",	JOptionPane.INFORMATION_MESSAGE);

        } while(true);

        this.npd.ta.setText("");

        if(!openFile(temp))
        {
            fileName="Untitled"; saved=true;
            this.npd.f.setTitle(fileName+" - "+applicationTitle);
        }
        if(!temp.canWrite())
            newFileFlag=true;

    }

    void updateStatus(File temp,boolean saved)
    {
        if(saved)
        {
            this.saved=true;
            fileName= temp.getName();
            if(!temp.canWrite())
            {fileName+="(Read only)"; newFileFlag=true;}
            fileRef=temp;
            npd.f.setTitle(fileName + " - "+applicationTitle);
            npd.statusBar.setText("File : "+temp.getPath()+" saved/opened successfully.");
            newFileFlag=false;
        }
        else
        {
            npd.statusBar.setText("Failed to save/open : "+temp.getPath());
        }
    }

    boolean confirmSave()
    {
        String strMsg="<html>The text in the "+fileName+" file has been changed.<br>"+
                "Do you want to save the changes?<html>";
        if(!saved)
        {
            int x=JOptionPane.showConfirmDialog(this.npd.f,strMsg,applicationTitle,JOptionPane.YES_NO_CANCEL_OPTION);

            if(x==JOptionPane.CANCEL_OPTION) return false;
            return x != JOptionPane.YES_OPTION || saveAsFile();
        }
        return true;
    }

    void newFile()
    {
        if(!confirmSave()) return;

        this.npd.ta.setText("");
        fileName= "Untitled";
        fileRef=new File(fileName);
        saved=true;
        newFileFlag=true;
        this.npd.f.setTitle(fileName+" - "+applicationTitle);
    }
}

  class MYTextEditor implements ActionListener, MenuConstants
{

    JFrame f;
    JTextArea ta;
    JLabel statusBar;

    String applicationName="Notepad";
    FileOperation fileHandler;
    JMenuItem cutItem,copyItem, deleteItem, selectAllItem;

    MYTextEditor() {
        String fileName = "Untitled";
        f = new JFrame(fileName + " - " + applicationName);
        ta = new JTextArea(30, 60);
        statusBar = new JLabel("||       Ln 1, Col 1  ", JLabel.RIGHT);
        f.add(new JScrollPane(ta), BorderLayout.CENTER);
        f.add(statusBar, BorderLayout.SOUTH);
        f.add(new JLabel("  "), BorderLayout.EAST);
        f.add(new JLabel("  "), BorderLayout.WEST);
        f.pack();
        f.setLocation(100, 50);
        f.setVisible(true);
        f.setLocation(150, 50);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        createMenuBar(f);

        fileHandler = new FileOperation(this);

        ta.addCaretListener(
                e -> {
                    int lineNumber = 0, column = 0, pos;

                    try {
                        pos = ta.getCaretPosition();
                        lineNumber = ta.getLineOfOffset(pos);
                        column = pos - ta.getLineStartOffset(lineNumber);
                    } catch (Exception ignored) {
                    }
                    if (ta.getText().length() == 0) {
                        lineNumber = 0;
                        column = 0;
                    }
                    statusBar.setText("||       Ln " + (lineNumber + 1) + ", Col " + (column + 1));
                });

        DocumentListener myListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                fileHandler.saved = false;
            }

            public void removeUpdate(DocumentEvent e) {
                fileHandler.saved = false;
            }

            public void insertUpdate(DocumentEvent e) {
                fileHandler.saved = false;
            }
        };
        ta.getDocument().addDocumentListener(myListener);

        WindowListener frameClose = new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (fileHandler.confirmSave()) System.exit(0);
            }
        };
        f.addWindowListener(frameClose);
    }

    ///////////////////////////////////
    public void actionPerformed(ActionEvent ev)
    {
        String cmdText=ev.getActionCommand();
        switch (cmdText) {
            case fileNew:
                fileHandler.newFile();
                break;
            case fileOpen:
                fileHandler.openFile();
                break;
            case fileSave:
                fileHandler.saveThisFile();
                break;
            case fileSaveAs:
                fileHandler.saveAsFile();
                break;
            case fileExit:
                if (fileHandler.confirmSave()) System.exit(0);
                break;
            case editCut:
                ta.cut();
                break;
            case editCopy:
                ta.copy();
                break;
            case editPaste:
                ta.paste();
                break;
            case editDelete:
                ta.replaceSelection("");
                break;
            case editSelectAll:
                ta.selectAll();
                break;
            case formatWordWrap: {
                JCheckBoxMenuItem temp = (JCheckBoxMenuItem) ev.getSource();
                ta.setLineWrap(temp.isSelected());
                break;
            }
            case viewStatusBar: {
                JCheckBoxMenuItem temp = (JCheckBoxMenuItem) ev.getSource();
                statusBar.setVisible(temp.isSelected());
                break;
            }
            case helpAboutNotepad:
                JOptionPane.showMessageDialog(MYTextEditor.this.f, aboutText, "About!", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                statusBar.setText("This " + cmdText + " command is yet to be implemented");
                break;
        }
    }

    JMenuItem createMenuItem(String s, int key,JMenu toMenu,ActionListener al)
    {
        JMenuItem temp=new JMenuItem(s,key);
        temp.addActionListener(al);
        toMenu.add(temp);

        return temp;
    }

    JMenuItem createMenuItem(String s, int key,JMenu toMenu,int aclKey,ActionListener al)
    {
        JMenuItem temp=new JMenuItem(s,key);
        temp.addActionListener(al);
        temp.setAccelerator(KeyStroke.getKeyStroke(aclKey,ActionEvent.CTRL_MASK));
        toMenu.add(temp);

        return temp;
    }

    JMenu createMenu(String s,int key,JMenuBar toMenuBar)
    {
        JMenu temp=new JMenu(s);
        temp.setMnemonic(key);
        toMenuBar.add(temp);
        return temp;
    }

    void createMenuBar(JFrame f)
    {
        JMenuBar mb=new JMenuBar();
        JMenuItem temp;

        JMenu fileMenu=createMenu(fileText,KeyEvent.VK_F,mb);
        JMenu editMenu=createMenu(editText,KeyEvent.VK_E,mb);
        JMenu helpMenu=createMenu(helpText,KeyEvent.VK_H,mb);

        createMenuItem(fileNew,KeyEvent.VK_N,fileMenu,KeyEvent.VK_N,this);
        createMenuItem(fileOpen,KeyEvent.VK_O,fileMenu,KeyEvent.VK_O,this);
        createMenuItem(fileSave,KeyEvent.VK_S,fileMenu,KeyEvent.VK_S,this);
        createMenuItem(fileSaveAs,KeyEvent.VK_A,fileMenu,this);
        fileMenu.addSeparator();
        fileMenu.addSeparator();
        createMenuItem(fileExit,KeyEvent.VK_X,fileMenu,this);

        temp=createMenuItem(editUndo,KeyEvent.VK_U,editMenu,KeyEvent.VK_Z,this);
        temp.setEnabled(false);
        editMenu.addSeparator();
        cutItem=createMenuItem(editCut,KeyEvent.VK_T,editMenu,KeyEvent.VK_X,this);
        copyItem=createMenuItem(editCopy,KeyEvent.VK_C,editMenu,KeyEvent.VK_C,this);
        createMenuItem(editPaste,KeyEvent.VK_P,editMenu,KeyEvent.VK_V,this);
        deleteItem=createMenuItem(editDelete,KeyEvent.VK_L,editMenu,this);
        deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
        editMenu.addSeparator();

        editMenu.addSeparator();
        selectAllItem=createMenuItem(editSelectAll,KeyEvent.VK_A,editMenu,KeyEvent.VK_A,this);


        temp.setEnabled(false);
        helpMenu.addSeparator();
        createMenuItem(helpAboutNotepad,KeyEvent.VK_A,helpMenu,this);

        MenuListener editMenuListener=new MenuListener()
        {
            public void menuSelected(MenuEvent evvvv)
            {
                selectAllItem.setEnabled(MYTextEditor.this.ta.getText().length() != 0);
                if(MYTextEditor.this.ta.getSelectionStart()==ta.getSelectionEnd())
                {
                    cutItem.setEnabled(false);
                    copyItem.setEnabled(false);
                    deleteItem.setEnabled(false);
                }
                else
                {
                    cutItem.setEnabled(true);
                    copyItem.setEnabled(true);
                    deleteItem.setEnabled(true);
                }
            }
            public void menuDeselected(MenuEvent evvvv){}
            public void menuCanceled(MenuEvent evvvv){}
        };
        editMenu.addMenuListener(editMenuListener);
        f.setJMenuBar(mb);
    }

    public static void main(String[] s)
    {
        new MYTextEditor();
    }
}

interface MenuConstants
{
    String fileText="File";
    String editText="Edit";
    String helpText="Help";

    String filupdateSteNew="New";
    String fileOpen="Open...";
    String fileSave="Save";
    String fileSaveAs="Save As...";
    String fileExit="Exit";

    String editUndo="Undo";
    String editCut="Cut";
    String editCopy="Copy";
    String editPaste="Paste";
    String editDelete="Delete";
    String editSelectAll="Select All";


    String formatWordWrap="Word Wrap";

    String viewStatusBar="Status Bar";

    String helpAboutNotepad="About Notepad";

    String aboutText=
            "<html><big>NotePad</big>"
                    +"<p align=right>Prepared For BVICAM!</p><br>"
                    +"<strong>Thanks for using Notepad!</strong><br>";
}