package notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI_edit implements ActionListener {
    GUI gui;
    GUI_edit(GUI gui)
    {
        this.gui = gui;
    }

    public void createEditMenu()
    {
        gui.copy = new JMenuItem("Copy");
        gui.paste = new JMenuItem("Paste");
        gui.cut = new JMenuItem("Cut");
        gui.selectAll = new JMenuItem("Select All");
        gui.undo = new JMenuItem("Undo");
        gui.redo = new JMenuItem("Redo");
        gui.selText = new String();

        // Setting Keyboard shortcuts
        gui.copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.CTRL_MASK));
        gui.paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , ActionEvent.CTRL_MASK));
        gui.cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
        gui.selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
        gui.undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z , ActionEvent.CTRL_MASK));
        gui.redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y , ActionEvent.CTRL_MASK));

        // Adding the menu items into edit menu
        gui.edit.add(gui.copy);
        gui.edit.add(gui.paste);
        gui.edit.add(gui.cut);
        gui.edit.add(gui.selectAll);
        gui.edit.add(gui.undo);
        gui.edit.add(gui.redo);

        // Adding Action Listener to edit menu items
        gui.copy.addActionListener(this);
        gui.paste.addActionListener(this);
        gui.cut.addActionListener(this);
        gui.selectAll.addActionListener(this);
        gui.undo.addActionListener(this);
        gui.redo.addActionListener(this);

        setUndoRedo();
    }

    public void setUndoRedo()
    {
        // Undo function
        gui.area.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                gui.um.addEdit(e.getEdit());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Copy"))
        {
            gui.selText = gui.area.getSelectedText();
        }
        else if(e.getActionCommand().equals("Paste"))
        {
            gui.area.insert(gui.selText , gui.area.getCaretPosition());
        }
        else if(e.getActionCommand().equals("Cut"))
        {
            gui.selText = gui.area.getSelectedText();
            gui.area.replaceRange("" , gui.area.getSelectionStart() , gui.area.getSelectionEnd());
        }
        else if(e.getActionCommand().equals("Select All"))
        {
            gui.area.selectAll();
        }
        else if(e.getActionCommand().equals("Undo"))
        {
            if(gui.um.canUndo())
                gui.um.undo();
        }
        else if(e.getActionCommand().equals("Redo"))
        {
            if(gui.um.canRedo())
                gui.um.redo();
        }
    }
}
