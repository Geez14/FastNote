import modules.UI.FastNoteUI;
import modules.event.FastNoteComponentsEventHandler;

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
  public static void main(String[] args) {
    FastNoteUI ui = new FastNoteUI();
    FastNoteComponentsEventHandler handler = new FastNoteComponentsEventHandler(ui);
    ui.getOpenItem().addActionListener(handler);
    ui.getSaveItem().addActionListener(handler);
  }
}
