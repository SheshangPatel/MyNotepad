package notepad;

import javax.swing.*;
import javax.swing.undo.UndoManager;

public class Main {

    public static void main(String[] args) {
	    new GUI();
    }
}

class GUI extends JFrame
{
    // Text Area
    JTextArea area;
    JScrollPane pane;

    // Menu bar
    JMenuBar menuBar;
    JMenu file , edit , format , help;
    JPanel statusBar;
    JLabel totalWordsAndCharacters;

    // File menu
    JMenuItem newfile , open , save , print , exit;

    // Edit menu
    JMenuItem copy , paste , cut , selectAll , undo , redo;

    // Format menu
    JMenuItem wordwrap;
    JMenu fontFamily , fontstyle , fontsize , fontcolor , backgroundcolor;
    JMenuItem familyTNR , familyVerdana , familyArial , familyCambria , familyCalibri;
    JMenuItem styleBold , styleItalic , stylePlain , styleBoldItalic;
    JMenuItem size12 , size14 , size16 , size18 , size20 , size22 , size24 , size28 , size32;
    JMenuItem fontRed , fontBlack , fontWhite , fontBlue , fontGreen;
    JMenuItem bgRed , bgBlack , bgWhite , bgBlue , bgGreen;

    // Help
    JMenuItem about;

    // Utility
    boolean isWordWrapON = false;   // Use in wordWrap function
    JDialog dialogBox; // Used in new File
    String selText; // Used in edit menu
    UndoManager um = new UndoManager(); // Used for undo and redo function

    GUI()
    {
        setVisible(true);
        setSize(600 , 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // For creating Text Area
        GUI_textarea textarea = new GUI_textarea(this);
        textarea.createTextArea();

        // For creating Menu bar
        GUI_menubar menubarObj = new GUI_menubar(this);
        menubarObj.createMenubar();

        // For creating file menu
        GUI_file menuFile = new GUI_file(this);
        menuFile.createFileMenu();

        // For creating edit menu
        GUI_edit menuEdit = new GUI_edit(this);
        menuEdit.createEditMenu();

        // For creating Format menu
        GUI_format menuFormat = new GUI_format(this);
        menuFormat.createFormatMenu();

        // For creating help menu
        GUI_help menuHelp = new GUI_help(this);
        menuHelp.createHelpMenu();
    }
}
