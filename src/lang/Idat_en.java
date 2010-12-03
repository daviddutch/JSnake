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
                                  {"play", "Play"},
                                  {"Pause", "Pause"},
                                  
                                  {"score", "Score"},
                                  {"cntEaten", "Eaten insects"},
                                  {"speed", "Speed"}, 
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
