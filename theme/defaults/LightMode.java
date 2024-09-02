package theme.defaults;

import java.awt.Color;
import java.awt.Font;

import theme.Theme;

public class LightMode extends Theme.ThemeBuilder {
  public LightMode() {
    super(
        new Font("Cascadia Mono", Font.PLAIN, 16),
        16,
        Color.WHITE,
        Color.BLACK,
        Color.BLACK,
        Color.BLUE);
  }
}
