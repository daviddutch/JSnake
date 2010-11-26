package lang;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class IdatTest {
  
  public static void main(String[] args) {
    Locale loc = new Locale((Locale.FRENCH.toString()));
    Locale loc2 = new Locale((Locale.ENGLISH.toString()));
    Locale loc3 = new Locale((Locale.ITALIAN.toString()));
    ResourceBundle bIdat = ResourceBundle.getBundle("lang.Idat", loc);
    System.out.println(loc);
    System.out.println(bIdat.getString("speed"));
    System.out.println(bIdat.getString("play"));
    bIdat = ResourceBundle.getBundle("lang.Idat", loc2);
    System.out.println(loc2);
    System.out.println(bIdat.getString("speed"));
    System.out.println(bIdat.getString("play"));
    bIdat = ResourceBundle.getBundle("lang.Idat", loc3);
    System.out.println(loc3);
    System.out.println(bIdat.getString("speed"));
    System.out.println(bIdat.getString("play"));
  }

}
