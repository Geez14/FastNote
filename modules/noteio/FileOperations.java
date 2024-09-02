package modules.noteio;

import javax.swing.JTextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileOperations {
  public static void readFile(JTextArea textArea, File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        textArea.append(line + "\n");
      }
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null,
          "Error reading file: " + ex.getMessage());
    }
  }

  public static void writeFile(JTextArea textArea, File file) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(textArea.getText());
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null,
          "Error writing file: " + ex.getMessage());
    }
  }
}