package ihm;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import java.util.*;

import world.WorldModel;
import world.GridPoint;

public class GamePanel extends JPanel {

  boolean runSnake = true;
  GeneralPath path = new GeneralPath();
  int width        = 400;
  int height       = 400;
  
  public GamePanel(WorldModel wm) {
    setSize(400, 400);
    setPreferredSize(getSize());
    
    setBackground(Color.GRAY);
    wm.addObserver(new GamePanelObserver(this));
    Thread animThread = new Thread(new AnimSnake(this, wm));
    animThread.start();
  }
  private GridPoint convert(GridPoint p){
    return new GridPoint(height/100*p.getX(), width/100*p.getY());
  }
  public void updatePath(Queue<GridPoint> gpq){
    path = new GeneralPath();
    Iterator<GridPoint> itr = gpq.iterator();
    GridPoint point = convert((GridPoint)itr.next());
    path.moveTo(point.getX(), point.getY());
    while(itr.hasNext()) {
      point = convert((GridPoint)itr.next());
      path.lineTo(point.getX(), point.getY());
    }
  }
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    //g2.translate(50, getHeight() - 50); // Move the origin to the lower left
    //g2.scale(1.0, -1.0); // Flip the sign of the coordinate system

    Rectangle2D box = new Rectangle2D.Double(0, 0, 400, 400);
    g2.setPaint(Color.WHITE);
    g2.fill(box);

    g2.setPaint(Color.BLUE);
    g2.setStroke(new BasicStroke(3));
    g2.draw(path);
    
  }
}
