package ihm;

import java.util.Observable;
import java.util.Observer;

import world.WorldModel;

public class GamePanelObserver implements Observer {
  GamePanel gp;
  
  public GamePanelObserver(GamePanel gp){
    this.gp = gp;
  }

  @Override
  public void update(Observable o, Object event) {
    WorldModel wm = (WorldModel) o;
    WorldModel.WorldEvents what = (WorldModel.WorldEvents) event;
    switch (what){
      case CONFIG_CHANGED:
        stateChanged(wm);
        break;
      case STEP_FORWARD:
        stepForward(wm);
        break;
    }
  }
  private void stateChanged(WorldModel wm){
    gp.stateChanged(wm.getState());
  }
  private void stepForward(WorldModel wm){
    gp.updatePath(wm.getSnake());
    gp.repaint();
  }

}
