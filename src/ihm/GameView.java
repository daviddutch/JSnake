package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import world.World;
import world.WorldModel;
import world.WorldModel.Direction;
import world.WorldModel.GameState;

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
    
    GamePanel gp = new GamePanel(wm);
    
    KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
    gp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), key);
    gp.getActionMap().put(gp.getInputMap().get(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0)), new ArrowsAction(wm, Direction.UP));
    key = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
    gp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), key);
    gp.getActionMap().put(gp.getInputMap().get(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0)), new ArrowsAction(wm, Direction.DOWN));
    key = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
    gp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), key);
    gp.getActionMap().put(gp.getInputMap().get(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0)), new ArrowsAction(wm, Direction.LEFT));
    key = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
    gp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), key);
    gp.getActionMap().put(gp.getInputMap().get(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0)), new ArrowsAction(wm, Direction.RIGHT));

    
    
    od = new OptionDialog(wm);
    od.setModal(true);
    
    wm.setState(GameState.PLAY);
    add(gp, BorderLayout.WEST);
    add(new StatsPanel(wm), BorderLayout.EAST);
  }
  public void setVisible(boolean state){
    super.setVisible(state);
    od.setVisible(true);
  }
}
