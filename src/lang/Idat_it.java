package lang;

import java.util.ListResourceBundle;

public class Idat_it extends ListResourceBundle{

  private Object[][] contents = { {"language", "Lingua"},
                                  {"french", "french_it"},
                                  {"english", "english_it"},
                                  {"italian", "italien_it"},
                                  {"color", "color_it"},
                                  {"blue", "Blue_it"},
                                  {"red", "Red_it"},
                                  {"pink", "Pink_it"},
                                  {"speed", "velocit�"},
                                  {"play", "Gioca"},
                                  {"Pause", "Pausa"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
