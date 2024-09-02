package com.geez14.fastnote;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import theme.Theme;

public class PluginLoader {
  public static List<Theme> loadThemes() {
    ServiceLoader<Theme> loader = ServiceLoader.load(Theme.class);
    List<Theme> themes = new ArrayList<>();
    for (Theme theme : loader) {
      themes.add(theme);
    }
    return themes;
  }
}