package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_format {
    GUI gui;

    GUI_format(GUI gui)
    {
        this.gui = gui;
    }

    public void createFormatMenu()
    {
        gui.wordwrap = new JMenuItem("Word Wrap : OFF");
        gui.fontFamily = new JMenu("Font Family");
        gui.fontstyle = new JMenu("Font Style");
        gui.fontsize = new JMenu("Font Size");
        gui.fontcolor = new JMenu("Font Color");
        gui.backgroundcolor = new JMenu("Background Color");

        // Adding items into format Menu
        gui.format.add(gui.wordwrap);
        gui.format.add(gui.fontFamily);
        gui.format.add(gui.fontstyle);
        gui.format.add(gui.fontsize);
        gui.format.add(gui.fontcolor);
        gui.format.add(gui.backgroundcolor);

        // Font family
        gui.familyArial = new JMenuItem("Arial");
        gui.familyCalibri = new JMenuItem("Calibri");
        gui.familyCambria = new JMenuItem("Cambria");
        gui.familyTNR = new JMenuItem("Times New Roman");
        gui.familyVerdana = new JMenuItem("Verdana");

        // Adding items into font family menu
        gui.fontFamily.add(gui.familyArial);
        gui.fontFamily.add(gui.familyCalibri);
        gui.fontFamily.add(gui.familyCambria);
        gui.fontFamily.add(gui.familyTNR);
        gui.fontFamily.add(gui.familyVerdana);

        // Font style
        gui.stylePlain = new JMenuItem("Plain");
        gui.styleBold = new JMenuItem("Bold");
        gui.styleItalic = new JMenuItem("Italic");
        gui.styleBoldItalic = new JMenuItem("Bold And Italic");

        // Adding items into font style menu
        gui.fontstyle.add(gui.stylePlain);
        gui.fontstyle.add(gui.styleBold);
        gui.fontstyle.add(gui.styleItalic);
        gui.fontstyle.add(gui.styleBoldItalic);

        // Font size
        gui.size12 = new JMenuItem("12");
        gui.size14 = new JMenuItem("14");
        gui.size16 = new JMenuItem("16");
        gui.size18 = new JMenuItem("18");
        gui.size20 = new JMenuItem("20");
        gui.size22 = new JMenuItem("22");
        gui.size24 = new JMenuItem("24");
        gui.size28 = new JMenuItem("28");
        gui.size32 = new JMenuItem("32");

        // Adding items into font size menu
        gui.fontsize.add(gui.size12);
        gui.fontsize.add(gui.size14);
        gui.fontsize.add(gui.size16);
        gui.fontsize.add(gui.size18);
        gui.fontsize.add(gui.size20);
        gui.fontsize.add(gui.size22);
        gui.fontsize.add(gui.size24);
        gui.fontsize.add(gui.size28);
        gui.fontsize.add(gui.size32);

        // Font color
        gui.fontBlack = new JMenuItem("Black");
        gui.fontWhite = new JMenuItem("White");
        gui.fontBlue = new JMenuItem("Blue");
        gui.fontRed = new JMenuItem("Red");
        gui.fontGreen = new JMenuItem("Green");

        // Adding items into font color menu
        gui.fontcolor.add(gui.fontBlack);
        gui.fontcolor.add(gui.fontWhite);
        gui.fontcolor.add(gui.fontBlue);
        gui.fontcolor.add(gui.fontRed);
        gui.fontcolor.add(gui.fontGreen);

        // Background color
        gui.bgBlack = new JMenuItem("Black");
        gui.bgWhite = new JMenuItem("White");
        gui.bgBlue = new JMenuItem("Blue");
        gui.bgRed = new JMenuItem("Red");
        gui.bgGreen = new JMenuItem("Green");

        // Adding items into font color menu
        gui.backgroundcolor.add(gui.bgBlack);
        gui.backgroundcolor.add(gui.bgWhite);
        gui.backgroundcolor.add(gui.bgBlue);
        gui.backgroundcolor.add(gui.bgRed);
        gui.backgroundcolor.add(gui.bgGreen);

        // Action Listeners using Anonymous class

        // Action Listener for Word Wrap
        ActionListener wrap = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!gui.isWordWrapON)
                {
                    gui.area.setLineWrap(true);
                    gui.area.setWrapStyleWord(true);
                    gui.wordwrap.setText("Word Wrap : ON");
                    gui.isWordWrapON = true;
                }
                else
                {
                    gui.area.setLineWrap(false);
                    gui.area.setWrapStyleWord(false);
                    gui.wordwrap.setText("Word Wrap : OFF");
                    gui.isWordWrapON = false;
                }
            }
        };
        gui.wordwrap.addActionListener(wrap);

        // Action Listener for font family
        ActionListener family = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFontByChangingFamily(e.getActionCommand());
            }
        };
        gui.familyArial.addActionListener(family);
        gui.familyCalibri.addActionListener(family);
        gui.familyCambria.addActionListener(family);
        gui.familyTNR.addActionListener(family);
        gui.familyVerdana.addActionListener(family);

        // Action Listener for Font style items
        ActionListener style = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Plain" :
                        createFontByChangingStyle(Font.PLAIN);
                        break;
                    case "Bold" :
                        createFontByChangingStyle(Font.BOLD);
                        break;
                    case "Italic" :
                        createFontByChangingStyle(Font.ITALIC);
                        break;
                    case "Bold And Italic" :
                        createFontByChangingStyle(Font.BOLD | Font.ITALIC);
                        break;
                }
            }
        };
        gui.stylePlain.addActionListener(style);
        gui.styleBold.addActionListener(style);
        gui.styleItalic.addActionListener(style);
        gui.styleBoldItalic.addActionListener(style);

        // Action Listener for Font Size items (Used Lambda Statement)
        ActionListener size = e -> {
            createFontByChangingSize(Integer.parseInt(e.getActionCommand()));
        };
        gui.size12.addActionListener(size);
        gui.size14.addActionListener(size);
        gui.size16.addActionListener(size);
        gui.size18.addActionListener(size);
        gui.size20.addActionListener(size);
        gui.size22.addActionListener(size);
        gui.size24.addActionListener(size);
        gui.size28.addActionListener(size);
        gui.size32.addActionListener(size);

        // Action Listener for Font color
        ActionListener fColor = e -> {
            switch (e.getActionCommand()) {
                case "Black" :
                    gui.area.setForeground(Color.BLACK);
                    break;
                case "White" :
                    gui.area.setForeground(Color.WHITE);
                    break;
                case "Red" :
                    gui.area.setForeground(Color.RED);
                    break;
                case "Blue" :
                    gui.area.setForeground(Color.BLUE);
                    break;
                case "Green" :
                    gui.area.setForeground(Color.GREEN);
                    break;
            }
        };
        gui.fontBlack.addActionListener(fColor);
        gui.fontWhite.addActionListener(fColor);
        gui.fontRed.addActionListener(fColor);
        gui.fontBlue.addActionListener(fColor);
        gui.fontGreen.addActionListener(fColor);

        // Action Listener for Background color
        ActionListener bColor = e -> {
            switch (e.getActionCommand()) {
                case "Black":
                    gui.area.setBackground(Color.BLACK);
                    break;
                case "White":
                    gui.area.setBackground(Color.WHITE);
                    break;
                case "Red":
                    gui.area.setBackground(Color.RED);
                    break;
                case "Blue":
                    gui.area.setBackground(Color.BLUE);
                    break;
                case "Green":
                    gui.area.setBackground(Color.GREEN);
                    break;
            }
        };
        gui.bgBlack.addActionListener(bColor);
        gui.bgWhite.addActionListener(bColor);
        gui.bgRed.addActionListener(bColor);
        gui.bgBlue.addActionListener(bColor);
        gui.bgGreen.addActionListener(bColor);
    }

    public void createFontByChangingFamily(String fontFamily)
    {
        Font newFont = new Font(fontFamily , gui.area.getFont().getStyle() , gui.area.getFont().getSize());
        gui.area.setFont(newFont);
    }

    public void createFontByChangingStyle(int fontStyle)
    {
        Font newFont = new Font(gui.area.getFont().getName() , fontStyle , gui.area.getFont().getSize());
        gui.area.setFont(newFont);
    }

    public void createFontByChangingSize(int size)
    {
        Font newFont = new Font(gui.area.getFont().getName() , gui.area.getFont().getStyle() , size);
        gui.area.setFont(newFont);
    }
}
