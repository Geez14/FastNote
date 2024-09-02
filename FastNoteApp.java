import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.WindowAdapter;
import com.geez14.fastnote.FastNoteUI;
import com.geez14.fastnote.FileOperations;
import com.geez14.fastnote.FastNoteComponentsEventHandler;

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
    // create UI
    ui = new FastNoteUI();
    FastNoteComponentsEventHandler handler = new FastNoteComponentsEventHandler(ui);

    // setIcon
    ui.setIconImage(new ImageIcon("assets/images/FastNote1.0.png").getImage());

    // add window listener
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

    // add action listener
    ui.getOpenItem().addActionListener(handler);
    ui.getSaveItem().addActionListener(handler);
  }
}
