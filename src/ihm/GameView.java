package ihm;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

import world.WorldModel;
import world.WorldModel.Direction;
import world.WorldModel.GameState;


public class GameView extends JFrame {
  WorldModel wm;
  OptionDialog od;
  JButton btPlay        = new JButton("Pause");
  JButton btStop        = new JButton();
  
  public GameView(WorldModel word) {
    this.wm = word;
    setTitle("Snake Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setSize(600, 700);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    //--- Place la fenêtre de l'application
    setLocation((screenSize.width - frameSize.width) / 2,
    (screenSize.height - frameSize.height) / 5);
    
    GamePanel gp = new GamePanel(wm);
    
    btPlay.addActionListener(new GameViewAction(this));
    btPlay.setActionCommand("pause");
    
    btStop.setText("Restart");
    btStop.addActionListener(new GameViewAction(this));
    btStop.setActionCommand("stop");
    
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
    
    ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();
    setLayout(layout);
    layout.addRow("a+*.......a");
    layout.addRow("...p.r..b.b");
    gp.addComponentListener(new GamePanelResize(gp));
    add(gp, "a");
    add(new StatsPanel(wm), "b");
    add(btPlay,"p");
    add(btStop,"r");
    
  }
  public void setVisible(boolean state){
    super.setVisible(state);
    od.setVisible(true);
  }
  public void setPause(){
    btPlay.setText("Play");
    btPlay.setActionCommand("play");
    wm.setState(GameState.PAUSE);
  }
  public void setPlay(){
    btPlay.setText("Pause");
    btPlay.setActionCommand("pause");
    wm.setState(GameState.PLAY);
  }
  public void setStop(){
    wm.setState(GameState.STOP);
    //wm.stop();
    od.setVisible(true);
  }
}
