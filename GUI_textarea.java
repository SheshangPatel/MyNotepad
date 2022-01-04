package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_textarea implements ActionListener {
    GUI gui;
    GUI_textarea(GUI gui)
    {
        this.gui = gui;
    }

    public void createTextArea()
    {
        gui.area = new JTextArea();
        Font defaultfont = new Font("Calibri" , Font.PLAIN , 14);
        gui.area.setFont(defaultfont);

        gui.pane = new JScrollPane(gui.area);
        gui.pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        gui.pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gui.add(gui.pane);

        gui.statusBar  = new JPanel();
        gui.statusBar.setLayout(new GridLayout());
        gui.add(gui.statusBar , BorderLayout.SOUTH);
        gui.totalWordsAndCharacters = new JLabel("Words : 0 Characters : 0");
        gui.statusBar.add(gui.totalWordsAndCharacters);
        Timer timer = new Timer(200 , this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = gui.area.getText();
        char[] array = s.toCharArray();
        int words = 0 , exChar = 0;
        for(int i = 0 ; i < array.length ; i++)
        {
            if(i == 0) words++;
            else
            {
                if((array[i] != ' ' && array[i] != '\n') && (array[i - 1] == ' ' || array[i - 1] == '\n'))words++;
            }

            if(array[i] == ' ' || array[i] == '\n')
                exChar++;
        }
        gui.totalWordsAndCharacters.setText("Words : " + words + " Characters : " + (array.length - exChar));
    }
}
