package Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class R extends Properties {
  private static R r;

  static {
    r = new R();
    try {
      r.loadFromXML(new FileInputStream("resource.xml"));
    } catch (IOException e) {
      System.out.println("PROPERTIES CANNOT BE LOADED....");
      e.printStackTrace();
      System.exit(0);
    }
  }

  // don't let any one instantiate it!
  private R() {
  }

  public static Set<Object> getKeys() {
    return r.keySet();
  }

  public static String getResource(String key) {
    String value = r.getProperty(key);
    if (value == null) {
      throw new ResourceNotFoundException("Resource: " + key + ", Not Found!");
    }
    return value;
  }

  static class ResourceNotFoundException extends RuntimeException {
    ResourceNotFoundException(String msg) {
      super(msg);
    }
  }
}