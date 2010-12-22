package ihm;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.*;

import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

import world.WorldModel;
import world.WorldModel.Direction;
import world.WorldModel.GameState;


public class GameView extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
WorldModel wm;
  OptionDialog od;
  ResourceBundle bIdat;
  
  JButton btPlay        = new JButton();
  JButton btStop        = new JButton();
  JButton btOption      = new JButton();
  
  public GameView(WorldModel word) {
	  
    this.wm = word;
    this.wm.addObserver((Observer) new GameViewObserver(this));
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
    
    btStop.addActionListener(new GameViewAction(this));
    btStop.setActionCommand("stop");
    
    btOption.addActionListener(new GameViewAction(this));
    btOption.setActionCommand("option");

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
    
    setText();
    
    od = new OptionDialog(wm);
    od.setModal(true);
    
    ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();
    setLayout(layout);
    layout.addRow("a+*.......a");
    layout.addRow(".o.p.r..b.b");
    gp.addComponentListener(new GamePanelResize(gp));
    add(gp, "a");
    add(new StatsPanel(wm), "b");
    add(btPlay,"p");
    add(btStop,"r");
    add(btOption,"o");
    
  }
  
  public void setText(){
    bIdat = ResourceBundle.getBundle("lang.Idat", wm.getLocale());
    btStop.setText(bIdat.getString("restart"));
    btOption.setText(bIdat.getString("option"));
    if(wm.getState().compareTo(GameState.PAUSE)==0){
      btPlay.setText(bIdat.getString("play"));
      btPlay.setActionCommand("play");
    }else{
      btPlay.setText(bIdat.getString("pause"));
      btPlay.setActionCommand("pause");
    }
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
  public void viewOption() {
    setPause();
    od.setVisible(true);
  }
  
  
}
