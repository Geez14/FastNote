package theme;

import java.awt.Color;
import java.awt.Font;

public interface Theme {
  Font getFont();

  int getFontSize();

  Color getBackgroundColor();

  Color getTextColor();

  Color getCursorColor();

  Color getSelectionColor();

  abstract class ThemeBuilder implements Theme {
    private Font font;
    private int fontSize;
    private Color backgroundColor;
    private Color textColor;
    private Color cursorColor;
    private Color selectionColor;

    public ThemeBuilder(Font font, int fontSize, Color backgroundColor, Color textColor,
        Color cursorColor, Color selectionColor) {
      this.font = font;
      this.fontSize = fontSize;
      this.backgroundColor = backgroundColor;
      this.textColor = textColor;
      this.cursorColor = cursorColor;
      this.selectionColor = selectionColor;
    }

    @Override
    public Font getFont() {
      return font;
    }

    @Override
    public int getFontSize() {
      return fontSize;
    }

    @Override
    public Color getBackgroundColor() {
      return backgroundColor;
    }

    @Override
    public Color getTextColor() {
      return textColor;
    }

    @Override
    public Color getCursorColor() {
      return cursorColor;
    }

    @Override
    public Color getSelectionColor() {
      return selectionColor;
    }
  }
}