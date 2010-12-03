package lang;

import java.util.ListResourceBundle;

public class Idat_en extends ListResourceBundle{

  private Object[][] contents = { {"language", "Language"},
                                  {"french", "French"},
                                  {"english", "English"},
                                  {"italian", "Italian"},
                                  {"color", "Color"},
                                  {"blue", "Blue"},
                                  {"red", "Red"},
                                  {"pink", "Pink"},
                                  {"speed", "Speed"},
                                  {"play", "Play"},
                                  {"Pause", "Pause"}                              
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
