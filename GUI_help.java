package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_help implements ActionListener {
    GUI gui;
    GUI_help(GUI gui)
    {
        this.gui = gui;
    }

    public void createHelpMenu()
    {
        gui.about = new JMenuItem("About");

        // Adding about in help menu
        gui.help.add(gui.about);
        gui.about.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Help_about();
    }
}

class Help_about extends JFrame implements ActionListener
{
    JButton b;
    Help_about()
    {
        setVisible(true);
        setBounds(500 , 200 , 625 , 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/pictures/Windows_11.png"));
        Image i2 = i1.getImage();
        i2.getScaledInstance(400 , 80 , Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100 , 35 , 400 , 80);
        add(l1);

        JLabel l2 = new JLabel("<html>Created By : Sheshang Patel<br>Published on 04-01-2022<br>All Rights Reserved<br><br>Notepad is a simple text Editor where you can<br> write , open , save your documents. It also allow user to set<br>font family , style , size , color and Background color<br><br>Contact me at : <br>Linkedin - https://www.linkedin.com/in/sheshang-patel/<br>Phone number : 9265992210</html>");
        l2.setBounds(130 , 10 , 600 , 500);
        l2.setFont(new Font("Cambria" , Font.PLAIN , 14));
        add(l2);

        b = new JButton("Okay");
        b.setBounds(450 , 400 , 75 , 25);
        add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
