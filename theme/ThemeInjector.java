package theme;
import javax.swing.JTextArea;

public class ThemeInjector {
  public static void applyTheme(Theme theme, JTextArea textArea, JTextArea lineNumber) {
    textArea.setBackground(theme.getBackgroundColor());
    textArea.setFont(theme.getFont());
    textArea.setBackground(theme.getBackgroundColor());
    textArea.setForeground(theme.getTextColor());
    textArea.setCaretColor(theme.getCursorColor());
    textArea.setSelectionColor(theme.getSelectionColor());
  }
}