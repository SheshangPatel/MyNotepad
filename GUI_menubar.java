package notepad;

import javax.swing.*;

public class GUI_menubar {
    GUI gui;

    GUI_menubar(GUI gui)
    {
        this.gui = gui;
    }
    public void createMenubar()
    {
        gui.menuBar = new JMenuBar();
        gui.file = new JMenu("File");
        gui.edit = new JMenu("Edit");
        gui.format = new JMenu("Format");
        gui.help = new JMenu("Help");

        // Adding all the menu in the menubar
        gui.menuBar.add(gui.file);
        gui.menuBar.add(gui.edit);
        gui.menuBar.add(gui.format);
        gui.menuBar.add(gui.help);

        // Adding the menu on the frame
        gui.setJMenuBar(gui.menuBar);
    }
}
