package lang;

import java.util.ListResourceBundle;

public class Idat_fr extends ListResourceBundle{

  private Object[][] contents = { {"language", "Langue"},
                                  {"french", "Fran�ais"},
                                  {"english", "Anglais"},
                                  {"italian", "Italien"},
                                  {"color", "Couleur"},
                                  {"blue", "Bleu"},
                                  {"red", "Rouge"},
                                  {"pink", "Rose"},
                                  {"play", "Jouer"},
                                  {"Pause", "Pause"},
                                  
                                  {"score", "Points"},
                                  {"cntEaten", "Insects mang�s"},
                                  {"speed", "Vitesse"}, 
  };
  
  protected Object[][] getContents() {
    return contents;
  }
  

}
