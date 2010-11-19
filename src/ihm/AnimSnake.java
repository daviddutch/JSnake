package ihm;

import world.WorldModel;

public class AnimSnake implements Runnable {
  private GamePanel animPanel;
  private float dx1=3, dy1=1, dx2=4, dy2=2;
  private WorldModel wm;
  //----------------------------------------------------------------------------
  public AnimSnake(GamePanel animPanel, WorldModel wm) {
    this.animPanel = animPanel;
    this.wm        = wm;
  }
  //----------------------------------------------------------------------------
  public void run() {
    while (animPanel.runSnake) {
      wm.stepForward();
      animPanel.repaint();
      try {
        Thread.sleep(200);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
