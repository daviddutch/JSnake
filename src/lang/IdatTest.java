package lang;

import java.util.Locale;
import java.util.ResourceBundle;

public class IdatTest {

  public static void main(String[] args) {
    Locale loc = new Locale("");
    ResourceBundle bIdat = ResourceBundle.getBundle("lang.Idat", loc);
    System.out.println(bIdat.getString("speed"));
    System.out.println(bIdat.getString("play"));
  }

}
