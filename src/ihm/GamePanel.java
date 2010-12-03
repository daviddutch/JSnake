package ihm;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import java.util.*;



import world.SnakeController;
import world.WorldModel;
import world.GridPoint;

public class GamePanel extends JPanel {

  boolean runSnake = true;
  GeneralPath path = new GeneralPath();
  int width        = 400;
  int height       = 400;
  WorldModel wm;
  
  public GamePanel(WorldModel wm) {
    
    //setPreferredSize(new Dimension(400, 400));
    
    setBackground(Color.BLACK);
    this.wm = wm;
    wm.addObserver(new GamePanelObserver(this));
    javax.swing.Timer timer = new javax.swing.Timer(100, new SnakeController(this, wm));
    timer.start();
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
    GridPoint point = convert((GridPoint)itr.next());
    
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
    
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    //g2.translate(50, getHeight() - 50); // Move the origin to the lower left
    //g2.scale(1.0, -1.0); // Flip the sign of the coordinate system

    Rectangle2D box = new Rectangle2D.Double(0, 0, width, height);
    g2.setPaint(Color.WHITE);
    g2.fill(box);

    g2.setPaint(Color.BLUE);
    g2.setStroke(new BasicStroke(width/WorldModel.GRID_WIDTH));
    g2.draw(path);
    
    double epsilon = 0;//(width/WorldModel.GRID_WIDTH);
    GridPoint insect = convert(wm.getInsect());
    Rectangle2D ins = new Rectangle2D.Double(insect.getX(), insect.getY()-epsilon, width/WorldModel.GRID_WIDTH, height/WorldModel.GRID_HEIGHT);
    g2.setPaint(Color.RED);
    g2.fill(ins);
    
  }
}
