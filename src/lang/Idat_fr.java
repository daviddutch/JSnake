package lang;

import java.util.ListResourceBundle;

public class Idat_fr extends ListResourceBundle{

  private Object[][] contents = { {"language", "Langue"},
                                  {"speed", "Vitesse"},
                                  {"french", "Français"},
                                  {"english", "Anglais"},
                                  {"italian", "Italien"},
                                  {"color", "Couleur"},
                                  {"play", "Jouer"},
                                  {"Pause", "Pause"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
