package ihm;

import java.awt.*;
import java.awt.geom.GeneralPath;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sun.jkernel.Bundle;

import java.net.URL;
import java.util.*;



import world.Insect;
import world.SnakeController;
import world.WorldModel;
import world.GridPoint;
import world.WorldModel.GameState;

public class GamePanel extends JPanel {
  private Image img;
  private Image snakeBody;
  private Image snakeHead;
  private Image imgInsect;
  
  private GameState state;
  
  boolean runSnake = true;
  GeneralPath path = new GeneralPath();
  int width        = 400;
  int height       = 400;
  GridPoint head;
  WorldModel wm;
  Iterator<GridPoint> snake;
  
  public GamePanel(WorldModel wm) {
	URL       url = getClass().getResource("/images/background.png");
    img       = Toolkit.getDefaultToolkit().getImage(url);
    
    url = getClass().getResource("/images/body.png");
    snakeBody = Toolkit.getDefaultToolkit().getImage(url);
    
    url = getClass().getResource("/images/head.png");
    snakeHead = Toolkit.getDefaultToolkit().getImage(url);
    
    url = getClass().getResource("/images/insect.png");
    imgInsect = Toolkit.getDefaultToolkit().getImage(url);
    
    this.wm = wm;
    wm.addObserver(new GamePanelObserver(this));
    wm.init();
    new SnakeController(wm);
    state = wm.getState();
  }
  private GridPoint convert(GridPoint p){
    return new GridPoint(height/WorldModel.GRID_WIDTH*p.getX(), width/WorldModel.GRID_HEIGHT*p.getY());
  }
  public void updateSize(){
    Dimension d = getSize();
    if (d.width<d.height){
      setPreferredSize(new Dimension(d.width, d.width));
      width  = d.width;
      height = d.width;
    }else{
      setPreferredSize(new Dimension(d.height, d.height));
      width  = d.height;
      height = d.height;
    }
  }
  public void updatePath(Queue<GridPoint> gpq){
    path = new GeneralPath();
    Iterator<GridPoint> itr = gpq.iterator();
    snake = gpq.iterator();
    GridPoint point = convert((GridPoint)itr.next());
    head = point;
    double epsilon = (width/WorldModel.GRID_WIDTH)/2;
    
    path.moveTo(point.getX()+epsilon, point.getY()+epsilon);
    
    while(itr.hasNext()) {
      point = convert((GridPoint)itr.next());
      path.lineTo(point.getX()+epsilon, point.getY()+epsilon);
    }
  }
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    //Draw background
    g.drawImage(img, 0, 0, width, height, null);
    
  //Draw snake by image
    if (snake!=null && snake.hasNext()){
      int snakeSize = width/WorldModel.GRID_WIDTH;
      GridPoint point = convert((GridPoint)snake.next());
      
      g.drawImage(snakeHead, (int)(point.getX()), (int)(point.getY()), snakeSize, snakeSize, null);
      
      while(snake.hasNext()) {
        point = convert((GridPoint)snake.next());
        g.drawImage(snakeBody, (int)(point.getX()), (int)(point.getY()), snakeSize, snakeSize, null);
      }
    }
    //Draw insects
    for(Insect ins : wm.getInsects()) {
      GridPoint insect = convert(ins);
      g.drawImage(imgInsect, (int)(insect.getX()), (int)(insect.getY()), width/WorldModel.GRID_WIDTH, width/WorldModel.GRID_WIDTH, null);
    }
    
    g.setFont(g.getFont().deriveFont(16f));
    
    ResourceBundle bIdat = ResourceBundle.getBundle("lang.Idat", wm.getLocale());
    
    switch (state){
      case GAME_OVER:
        g.setColor(Color.RED);
        String msg = bIdat.getString("gameover");
        g.drawString(msg, width/2-g2.getFontMetrics().stringWidth(msg), height/2);
        break;
      case PAUSE:
        g.setColor(Color.YELLOW);
        g.drawString(bIdat.getString("gamepause"), width/2, height/2);
        break;
      case STOP:
        g.setColor(Color.PINK);
        g.drawString(bIdat.getString("gamestop"), width/2, height/2);
        break;
    }
  }
  public void stateChanged(GameState state) {
    this.state = state;
    this.repaint();
  }
}
