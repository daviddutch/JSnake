package lang;

import java.util.ListResourceBundle;

public class Idat extends ListResourceBundle{

  private Object[][] contents = { {"language", "Language"},
                                  {"speed", "Speed"},
                                  {"play", "Play"},
                                  {"Pause", "Pause"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
