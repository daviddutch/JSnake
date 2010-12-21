package world;

import javax.swing.UIManager;

import ihm.*;

public class Main {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    WorldModel wm    = new WorldModel();
    GameView gv = new GameView(wm);
    
    gv.setVisible(true);
  }

}
