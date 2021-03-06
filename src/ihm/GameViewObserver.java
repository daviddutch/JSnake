package ihm;

import java.util.Observable;
import java.util.Observer;

import world.WorldModel;

public class GameViewObserver implements Observer {

  GameView my;
  
  public GameViewObserver(GameView o){
    my = o;
  }
  public void update(Observable o, Object event) {
    WorldModel wm = (WorldModel) o;
    WorldModel.WorldEvents what = (WorldModel.WorldEvents) event;
    switch (what){
      case CONFIG_CHANGED:
        configChanged(wm);
        break;
      case STEP_FORWARD:
        stepForward(wm);
        break;
    }
  }
  private void configChanged(WorldModel wm){
    my.setText();
  }
  private void stepForward(WorldModel wm){
    
  }

}
