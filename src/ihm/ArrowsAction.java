package ihm;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import world.WorldModel;
import world.WorldModel.Direction;

public class ArrowsAction extends AbstractAction{
  /**
	 * 
	 */
	private static final long serialVersionUID = -5605740829232068067L;
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
