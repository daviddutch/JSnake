package ihm;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import world.WorldModel;

public class GamePanel extends JPanel {

  boolean runSnake = true;
  int offset = 50;
  
  public GamePanel(WorldModel wm) {
    setSize(400, 400);
    setPreferredSize(getSize());
    
    setBackground(Color.GRAY);
    wm.addObserver(new GamePanelObserver(this));
    Thread animThread = new Thread(new AnimSnake(this, wm));
    animThread.start();
  }
  public void updateOffset(int incr){
    offset+=incr;
  }
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.translate(50, getHeight() - 50); // Move the origin to the lower left
    g2.scale(1.0, -1.0); // Flip the sign of the coordinate system

    Rectangle2D box = new Rectangle2D.Double(0, 0, 400, 400);
    g2.setPaint(Color.WHITE);
    g2.fill(box);
    
    GeneralPath path = new GeneralPath();
    
    path.moveTo(offset, offset); // Point de départ
    path.lineTo(offset+20, offset);
    path.lineTo(offset+20, offset+50);
    path.lineTo(offset+70, offset+50);
    path.lineTo(offset+70, offset+100);

    g2.setPaint(Color.BLUE);
    g2.setStroke(new BasicStroke(3));
    g2.draw(path);
    
  }
}
