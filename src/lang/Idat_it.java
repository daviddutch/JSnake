package lang;

import java.util.ListResourceBundle;

public class Idat_it extends ListResourceBundle{

  private Object[][] contents = { {"language", "Lingua"},
                                  {"french", "french_it"},
                                  {"english", "english_it"},
                                  {"italian", "italien_it"},
                                  {"color", "color_it"},
                                  {"speed", "velocità"},
                                  {"play", "Gioca"},
                                  {"Pause", "Pausa"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
