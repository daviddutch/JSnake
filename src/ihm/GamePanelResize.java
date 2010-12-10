package ihm;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GamePanelResize implements ComponentListener {

  private GamePanel gp;
  
  public GamePanelResize(GamePanel gamePanel) {
    gp = gamePanel;
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
    gp.updateSize();
  }

  @Override
  public void componentShown(ComponentEvent e) {
    // TODO Auto-generated method stub
    
  }

}
