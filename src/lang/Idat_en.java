package lang;

import java.util.ListResourceBundle;

public class Idat_en extends ListResourceBundle{

  private Object[][] contents = { {"language", "Language"},
      {"french", "French"},
      {"english", "English"},
      {"italian", "Italian"},
      {"play", "Play"},
      {"Pause", "Pause"},
      {"option", "Option"},
      {"score", "Score"},
      {"cntEaten", "Eaten insects"},
      {"speed", "Speed"},                             
};
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
