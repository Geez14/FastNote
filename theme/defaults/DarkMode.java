package theme.defaults;

import java.awt.Color;
import java.awt.Font;

import theme.Theme;

// getter methods are handle through ThemeBuilder class
public class DarkMode extends Theme.ThemeBuilder {
  public DarkMode() {
    super(new Font("Consolas", Font.PLAIN, 16), 16, new Color(0x212121), Color.WHITE, Color.WHITE, Color.BLUE);
  }
}