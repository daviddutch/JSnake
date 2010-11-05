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
    World      world = new World(wm);
    GameView gv = new GameView(world, wm);
    
    gv.setVisible(true);
  }

}
