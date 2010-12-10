package ihm;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.util.*;



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
      
    img       = new ImageIcon("images/background.png").getImage();
    snakeBody = new ImageIcon("images/body.png").getImage();
    snakeHead = new ImageIcon("images/head.png").getImage();
    imgInsect = new ImageIcon("images/insect.png").getImage();
    
    this.wm = wm;
    wm.addObserver(new GamePanelObserver(this));
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
    //Draw insect
    GridPoint insect = convert(wm.getInsect());
    g.drawImage(imgInsect, (int)(insect.getX()), (int)(insect.getY()), width/WorldModel.GRID_WIDTH, width/WorldModel.GRID_WIDTH, null);
    
    g.setFont(g.getFont().deriveFont(16f));
    
    switch (state){
      case GAME_OVER:
        g.setColor(Color.RED);
        String msg = "GAME OVER !!\nYou Loose !";
        g.drawString(msg, width/2-g2.getFontMetrics().stringWidth(msg), height/2);
        break;
      case PAUSE:
        g.setColor(Color.YELLOW);
        g.drawString("Game on pause", width/2, height/2);
        break;
      case STOP:
        g.setColor(Color.PINK);
        g.drawString("Game stopped", width/2, height/2);
        break;
    }
  }
  public void stateChanged(GameState state) {
    this.state = state;
    this.repaint();
  }
}
