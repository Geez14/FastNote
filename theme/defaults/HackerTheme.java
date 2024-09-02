package theme.defaults;

import java.awt.Color;
import java.awt.Font;

import theme.Theme;

public class HackerTheme extends Theme.ThemeBuilder {

  public HackerTheme() {
    super(
        new Font("JetBrains Mono", Font.PLAIN, 16), 16,
        Color.BLACK,
        Color.GREEN, Color.GREEN, Color.GREEN);
  }
}
