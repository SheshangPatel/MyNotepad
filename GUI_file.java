package notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;

public class GUI_file implements ActionListener {
    GUI gui;
    GUI_file(GUI gui)
    {
        this.gui = gui;
    }

    public void createFileMenu()
    {
        gui.newfile = new JMenuItem("New");
        gui.open = new JMenuItem("Open");
        gui.save = new JMenuItem("Save");
        gui.print = new JMenuItem("Print");
        gui.exit = new JMenuItem("Exit");

        // Setting shortcut keys for menu items
        gui.newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
        gui.open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));
        gui.save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
        gui.print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
        gui.exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE , 0));

        // Adding all the menu items in the file menu
        gui.file.add(gui.newfile);
        gui.file.add(gui.open);
        gui.file.add(gui.save);
        gui.file.add(gui.print);
        gui.file.add(gui.exit);

        // Adding Action Listeners to file menu items
        gui.newfile.addActionListener(this);
        gui.open.addActionListener(this);
        gui.save.addActionListener(this);
        gui.print.addActionListener(this);
        gui.exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("New"))
        {
            gui.dialogBox = new JDialog(gui , "Save" , true);
            gui.dialogBox.setLayout(new FlowLayout());
            gui.dialogBox.setBounds(620 , 300 , 300 , 150);
            JButton yes , no;
            JLabel l;
            yes = new JButton("YES");
            yes.addActionListener(this);
            no = new JButton("NO");
            no.addActionListener(this);
            l = new JLabel("<html><center>Your current progress will be lost.<br>Do you want to save it ?</center></html>");
            l.setFont(new Font("Calibri" , Font.BOLD , 16));
            gui.dialogBox.add(l);
            gui.dialogBox.add(yes);
            gui.dialogBox.add(no);
            gui.dialogBox.setVisible(true);
            gui.area.setText("");
            Font defaultfont = new Font("Calibri" , Font.PLAIN , 14);
            gui.area.setFont(defaultfont);
            gui.area.setForeground(Color.BLACK);
            gui.area.setBackground(Color.WHITE);
        }
        else if(e.getActionCommand().equals("Open"))
        {
            JFileChooser openfile = new JFileChooser();

            openfile.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Only .txt files" , "txt");
            openfile.addChoosableFileFilter(extensionFilter);

            int action = openfile.showOpenDialog(gui);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }

            File myfile = openfile.getSelectedFile();
            try {
                BufferedReader inputfile = new BufferedReader(new FileReader(myfile));
                gui.area.read(inputfile , null);
            }
            catch(IOException ioException) {
                ioException.printStackTrace();
            }
            GUI_edit menuedit = new GUI_edit(gui);
            menuedit.setUndoRedo();
        }
        else if(e.getActionCommand().equals("Save") || e.getActionCommand().equals("YES"))
        {
            JFileChooser saveas = new JFileChooser();
            int action = saveas.showSaveDialog(gui);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }

            File myfile = new File(saveas.getSelectedFile() + ".txt");
            try {
                if (!myfile.exists()) {
                    myfile.createNewFile();
                }
                BufferedWriter outputfile = new BufferedWriter(new FileWriter(myfile));
                gui.area.write(outputfile);
                outputfile.close();
            }
            catch(IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("Print"))
        {
            try {
                gui.area.print();
            }
            catch(PrinterException printerException)
            {
                printerException.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }

        if(e.getActionCommand().equals("YES") || e.getActionCommand().equals("NO"))
        {
            gui.dialogBox.dispose();
        }
    }
}
