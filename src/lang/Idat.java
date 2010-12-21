package lang;

import java.util.ListResourceBundle;

public class Idat extends ListResourceBundle{

  private Object[][] contents = { {"language", "Language"},
                                  {"french", "French"},
                                  {"english", "English"},
                                  {"italian", "Italian"},
                                  {"play", "Play"},
                                  {"pause", "Pause"},
                                  {"gameover", "GAME OVER !!\nYou Loose !"},
                                  {"gamepause", "Game on pause"},
                                  {"gamestop", "Game on stop"},
                                  {"option", "Option"},
                                  {"restart", "Restart"},
                                  {"score", "Score"},
                                  {"cntEaten", "Eaten insects"},
                                  {"speed", "Speed"},                             
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
