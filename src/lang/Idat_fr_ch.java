package lang;

import java.util.ListResourceBundle;

public class Idat_fr_ch extends ListResourceBundle{

  private Object[][] contents = { {"language", "Langue"},
                                  {"speed", "Vitesse"},
                                  {"play", "Jouer"},
                                  {"Pause", "Pause"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
