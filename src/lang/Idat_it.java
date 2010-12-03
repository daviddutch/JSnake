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
                                  {"play", "Gioca"},
                                  {"Pause", "Pausa"},
                                  
                                  {"score", "Punti"},
                                  {"cntEaten", "Insetti mangiati"},
                                  {"speed", "Velocità"}    
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
