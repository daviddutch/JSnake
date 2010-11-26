package ihm;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import world.WorldModel;
import world.WorldModel.Direction;

public class ArrowsAction extends AbstractAction{
  WorldModel wm;
  Direction d;
  
  public ArrowsAction(WorldModel wm, Direction d){
    this.wm = wm;
    this.d  = d;
  }
  @Override
  public void actionPerformed(ActionEvent evt) {
    wm.setNextDirection(d);
  }

}
