package lang;

import java.util.ListResourceBundle;

public class Idat_it extends ListResourceBundle{

  private Object[][] contents = { {"language", "Lingua"},
                                  {"speed", "velocit�"},
                                  {"play", "Gioca"},
                                  {"Pause", "Pausa"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
