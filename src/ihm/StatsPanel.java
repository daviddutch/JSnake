package ihm;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import world.WorldModel;

import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

public class StatsPanel extends JPanel {
  public StatsPanel(WorldModel wm){
    ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();
    setLayout(layout);
    layout.addRow("a.......ab.b");
    layout.addRow("c.......cd.d");
    layout.addRow("e.......ef.f");
    add(new JLabel("Score :"), "a");
    add(new JLabel("30"), "b");
    add(new JLabel("Nb manger :"), "c");
    add(new JLabel("3"), "d");
    add(new JLabel("Vitesse :"), "e");
    add(new JLabel("10"), "f");
    
    setSize(230, 200);
    setPreferredSize(getSize());
    
    setBackground(Color.GRAY);
    
  }
}
