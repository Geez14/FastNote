package com.geez14.fastnote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FastNoteComponentsEventHandler implements ActionListener {
  private FastNoteUI ui;
  private JFileChooser fileChooser;

  private FileNameExtensionFilter filter = new FileNameExtensionFilter("Text and Ascii Files", "js", "txt", "java", "c",
      "cpp", "py", "html", "css", "xml", "json", "md", "csv", "tsv", "sql", "sh", "bat", "log", "yaml", "yml",
      "properties", "ini", "cfg", "conf", "cnf", "config", "env", "envrc");

  public FastNoteComponentsEventHandler(FastNoteUI ui) {
    this.ui = ui;
    fileChooser = new JFileChooser();
    fileChooser.setFileFilter(filter);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == ui.getOpenItem()) {
      // if changes is not saved and trying to open another file
      if (!ui.isSavedChange) {
        int confirm = JOptionPane.showConfirmDialog(ui, "Do you want to save the unchanged changes?", "Save File",
            JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
          // open the additional window to save that changes
          JFileChooser fileChooser = new JFileChooser();
          int result = fileChooser.showSaveDialog(ui);
          if (result == JFileChooser.APPROVE_OPTION) {
            FileOperations.writeFile(ui.getTextArea(), fileChooser.getSelectedFile());
            ui.isSavedChange = true;
          } else {
            return;
          }
        }
      }
      // when the programm reach here, either the file is saved or user didn't choosed
      // file so return.
      int result = fileChooser.showOpenDialog(ui);
      if (result == JFileChooser.APPROVE_OPTION) {
        // clean the page!
        ui.getTextArea().setText("");
        FileOperations.readFile(ui.getTextArea(), fileChooser.getSelectedFile());
        ui.setTitle("FastNote1.0(" + fileChooser.getSelectedFile().getName() + ")");
      }
    } else if (e.getSource() == ui.getSaveItem()) {
      int result = fileChooser.showSaveDialog(ui);
      if (result == JFileChooser.APPROVE_OPTION) {
        FileOperations.writeFile(ui.getTextArea(), fileChooser.getSelectedFile());
        ui.isSavedChange = true;
        ui.setTitle("FastNote1.0(" + fileChooser.getSelectedFile().getName() + ")");
      }
    }
  }
}
