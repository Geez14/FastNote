package modules.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
// import javax.swing.JOptionPane;

import modules.UI.FastNoteUI;
import modules.noteio.FileOperations;

public class FastNoteComponentsEventHandler implements ActionListener {
  private FastNoteUI ui;
  private JFileChooser fileChooser;

  public FastNoteComponentsEventHandler(FastNoteUI ui) {
    this.ui = ui;
    fileChooser = new JFileChooser();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == ui.getOpenItem()) {
      int result = fileChooser.showOpenDialog(ui);
      if (result == JFileChooser.APPROVE_OPTION) {
        FileOperations.readFile(ui.getTextArea(), fileChooser.getSelectedFile());
      }
    } else if (e.getSource() == ui.getSaveItem()) {
      int result = fileChooser.showSaveDialog(ui);
      if (result == JFileChooser.APPROVE_OPTION) {
        FileOperations.writeFile(ui.getTextArea(), fileChooser.getSelectedFile());
      }
    }
    // else if (e.getSource() == ui.getExitItem()) {
    // System.out.println("Exit");
    // // Show confirmation dialog
    // int confirm = JOptionPane.showConfirmDialog(ui, "Do you want to save changes
    // before exiting?",
    // "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
    // if (confirm == JOptionPane.YES_OPTION) {
    // int result = fileChooser.showSaveDialog(ui);
    // if (result == JFileChooser.APPROVE_OPTION) {
    // FileOperations.writeFile(ui.getTextArea(), fileChooser.getSelectedFile());
    // }
    // } else if (confirm == JOptionPane.NO_OPTION) {
    // System.exit(0);
    // }
    // // If CANCEL_OPTION or closed dialog, do nothing

    // }
  }
}
