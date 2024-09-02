package com.geez14.fastnote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.Element;

import theme.Theme;
import theme.ThemeInjector;
import theme.defaults.DarkMode;
import theme.defaults.HackerTheme;
import theme.defaults.LightMode;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;

public class FastNoteUI extends JFrame {
  final private JTextArea textArea;
  private JTextArea lineNumbers;

  // parent
  private JMenuBar menuBar;

  // children of menuBar
  private JMenu fileMenu;

  // children of fileMenu
  private JMenuItem openItem, saveItem;

  // children of menuBar
  private JMenu helpMenu;

  // children of menuBar
  private JMenu toolMenu;

  // state variable
  public boolean isSavedChange = true;

  // state wordwrap
  public boolean isWordWrap = false;
  private JCheckBoxMenuItem wordWrapItem;

  // defualt theme menueBar
  private JMenu themeMenue;

  // default themes
  private Theme defaultTheme[] = { new LightMode(), new DarkMode(), new HackerTheme() };

  // currentTheme
  private Theme currentTheme;

  public FastNoteUI() {
    // textArea is final
    textArea = new JTextArea();
    setTitle("FastNote(unknown)");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initMenueBar();
    initTextArea();
    setVisible(true);
  }

  void initTextArea() {
    textArea.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        isSavedChange = false;
      }
    });
    // injecting color
    JScrollPane scrollPane = new JScrollPane(textArea);
    // // Create the line numbers area
    lineNumbers = new JTextArea("0");
    lineNumbers.setBackground(Color.LIGHT_GRAY);
    lineNumbers.setEditable(false);
    lineNumbers.setFont(new Font("Calibri", Font.PLAIN, 16));

    // Synchronize scrolling
    scrollPane.setRowHeaderView(lineNumbers);
    // Add document listener to update line numbers
    textArea.getDocument().addDocumentListener(new DocumentListener() {
      public String getText() {
        // carterPosition is index of the cursor
        int caretPosition = textArea.getDocument().getLength();
        Element root = textArea.getDocument().getDefaultRootElement();
        StringBuilder text = new StringBuilder("1"+System.lineSeparator());
        // iterate through the textArea and add line numbers
        for (int i = 2; i < root.getElementIndex(caretPosition)+2 ; i++) {
          text.append(i).append(System.lineSeparator());
        }
        return text.toString();
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        lineNumbers.setText(getText());
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        lineNumbers.setText(getText());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        lineNumbers.setText(getText());
      }
    });

    add(scrollPane, BorderLayout.CENTER);
    currentTheme = defaultTheme[0];
    populateTheme();
  }

  void initMenueBar() {
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    openItem = new JMenuItem("Open");
    saveItem = new JMenuItem("Save");

    toolMenu = new JMenu("Tools");
    themeMenue = new JMenu("Themes");
    wordWrapItem = new JCheckBoxMenuItem("Word Wrap");

    helpMenu = new JMenu("Help");
    toolMenu.add(themeMenue);
    menuBar.add(fileMenu);
    menuBar.add(toolMenu);
    menuBar.add(helpMenu);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    toolMenu.add(wordWrapItem);
    setJMenuBar(menuBar);

    wordWrapItem.addActionListener(e -> textArea.setLineWrap(wordWrapItem.isSelected()));

    // adding the defualt theme in the Theme menue
    for (Theme theme : defaultTheme) {
      JMenuItem themeItem = new JMenuItem(theme.getClass().getSimpleName());
      themeMenue.add(themeItem);
      themeItem.addActionListener(e -> {
        currentTheme = theme;
        populateTheme();
      });
    }

    // loading pluging themes
    PluginLoader.loadThemes().forEach(i -> {
      System.out.println("Theme: " + i.getClass().getSimpleName());
      // iterate through each Theme implementing class and create an item for it
      JMenuItem themeItem = new JMenuItem(i.getClass().getSimpleName());
      themeMenue.add(themeItem);
      themeItem.addActionListener(e -> {
        currentTheme = i;
        populateTheme();
      });
    });
  }

  public void populateTheme() {
    ThemeInjector.applyTheme(currentTheme, textArea, lineNumbers);
  }

  public JTextArea getTextArea() {
    return textArea;
  }

  public JMenuItem getOpenItem() {
    return openItem;
  }

  public JMenuItem getSaveItem() {
    return saveItem;
  }

}
