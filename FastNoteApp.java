
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.geez14.fastnote.FastNoteUI;
import com.geez14.fastnote.FastNoteComponentsEventHandler;
import com.geez14.fastnote.FileOperations;

/**
 * The FastNoteApp class is the entry point for the FastNote application.
 * It contains the main method which is responsible for starting the
 * application.
 * 
 * 
 * @autor Geez14
 * @version 1.0
 */
public class FastNoteApp {
  static FastNoteUI ui;

  public static void main(String[] args) {
    ui = new FastNoteUI();
    FastNoteComponentsEventHandler handler = new FastNoteComponentsEventHandler(ui);
    ui.setIconImage(new ImageIcon("assets/images/FastNote1.0.png").getImage());
    ui.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if (!ui.isSavedChange) {
          int confirm = JOptionPane.showConfirmDialog(ui, "Do you want to save the unchanged changes?", "Save File",
              JOptionPane.YES_NO_OPTION);
          if (confirm == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(ui);
            if (result == JFileChooser.APPROVE_OPTION) {
              FileOperations.writeFile(ui.getTextArea(), fileChooser.getSelectedFile());
              ui.isSavedChange = true;
            }
          }
        }
        System.exit(0);
      }
    });
    ui.getOpenItem().addActionListener(handler);
    ui.getSaveItem().addActionListener(handler);
  }
}
