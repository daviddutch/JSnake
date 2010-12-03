package ihm;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GamePanelResize implements ComponentListener {

  private GameView gv;
  
  public GamePanelResize(GameView gameView) {
    gv = gameView;
  }

  @Override
  public void componentHidden(ComponentEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void componentMoved(ComponentEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void componentResized(ComponentEvent e) {
   
  }

  @Override
  public void componentShown(ComponentEvent e) {
    // TODO Auto-generated method stub
    
  }

}
