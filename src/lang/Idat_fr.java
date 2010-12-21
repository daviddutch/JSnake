package lang;

import java.util.ListResourceBundle;

public class Idat_fr extends ListResourceBundle{

  private Object[][] contents = { {"language", "Langue"},
      {"french", "Français"},
      {"english", "Anglais"},
      {"italian", "Italien"},
      {"play", "Play"},
      {"Pause", "Pause"},
      {"option", "Option"},
      {"gameover", "GAME OVER !!\nVous avez perdu !"},
      {"gamepause", "jeu en pause"},
      {"gamestop", "jeu en arrêt"},
      {"score", "Score"},
      {"cntEaten", "Insectes mangés"},
      {"speed", "Vitesse"},                             
};
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
