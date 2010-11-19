package ihm;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

import world.WorldModel;

public class OptionDialog extends JDialog {
  
  public OptionDialog(WorldModel wm){
    setTitle("Snake options !!");
    setSize(400, 200);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    //--- Place la fen�tre de l'application
    setLocation((screenSize.width - frameSize.width) / 2,
    (screenSize.height - frameSize.height) / 5);
  }
}
