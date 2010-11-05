package ihm;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class OptionDialog extends JDialog {
  public OptionDialog(){
    setTitle("Snake options !!");
    setSize(400, 200);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    //--- Place la fenêtre de l'application
    setLocation((screenSize.width - frameSize.width) / 2,
    (screenSize.height - frameSize.height) / 5);
  }
}
