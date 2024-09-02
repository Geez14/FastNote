package modules.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Resource.R;

public class FastNoteUI extends JFrame {
  private JTextArea textArea;
  private JTextArea lineNumbers;
  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenuItem openItem, saveItem;
  private static ImageIcon icon = new ImageIcon(R.getResource("AppIcon"));

  public FastNoteUI() {
    // icon setup
    Image image = icon.getImage();
    setIconImage(image);
    setTitle("Simple Notepad");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createMenueBar();
    // main text area
    // Create the main text area
    textArea = new JTextArea();
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

    // Create the line numbers area
    lineNumbers = new JTextArea("1");
    lineNumbers.setBackground(Color.LIGHT_GRAY);
    lineNumbers.setEditable(false);
    lineNumbers.setFont(new Font("Monospaced", Font.PLAIN, 16));

    // Synchronize scrolling
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setRowHeaderView(lineNumbers);
    add(scrollPane, BorderLayout.CENTER);

    setVisible(true);
  }

  void createMenueBar() {
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    openItem = new JMenuItem("Open");
    saveItem = new JMenuItem("Save");
    menuBar.add(fileMenu);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    setJMenuBar(menuBar);
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
