package com.geez14.fastnote;

import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class TextFilter {
  // DocumentFilter to allow only ASCII characters
  static class AsciiOnlyFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
        throws BadLocationException {
      if (isAscii(string)) {
        super.insertString(fb, offset, string, attr);
      }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs)
        throws BadLocationException {
      if (isAscii(text)) {
        super.replace(fb, offset, length, text, attrs);
      }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
      super.remove(fb, offset, length);
    }

    private boolean isAscii(String text) {
      for (char c : text.toCharArray()) {
        if (c > 127) {
          return false;
        }
      }
      return true;
    }
  }
}
