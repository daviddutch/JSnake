package lang;

import java.util.ListResourceBundle;

public class Idat_fr extends ListResourceBundle{

  private Object[][] contents = { {"language", "Langue"},
      {"french", "Fran�ais"},
      {"english", "Anglais"},
      {"italian", "Italien"},
      {"play", "Play"},
      {"Pause", "Pause"},
      {"option", "Option"},
      {"gameover", "GAME OVER !!\nVous avez perdu !"},
      {"gamepause", "jeu en pause"},
      {"gamestop", "jeu en arr�t"},
      {"score", "Score"},
      {"cntEaten", "Insectes mang�s"},
      {"speed", "Vitesse"},                             
};
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
