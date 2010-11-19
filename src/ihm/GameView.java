package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import world.World;
import world.WorldModel;

public class GameView extends JFrame {
  OptionDialog od;
  
  public GameView(World world, WorldModel wm) {
    setTitle("Snake 2 !!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setSize(700, 700);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    //--- Place la fenêtre de l'application
    setLocation((screenSize.width - frameSize.width) / 2,
    (screenSize.height - frameSize.height) / 5);
    
    od = new OptionDialog(wm);
    od.setModal(true);
    
    add(new GamePanel(wm), BorderLayout.WEST);
    add(new StatsPanel(wm), BorderLayout.EAST);
  }
  public void setVisible(boolean state){
    super.setVisible(state);
    od.setVisible(true);
  }
}
