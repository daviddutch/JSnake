package ihm;

import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import world.WorldModel;

import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

public class StatsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	ResourceBundle bIdat;
	JLabel lbScore = new JLabel();
	JLabel lbCntEaten = new JLabel();
	JLabel lbSpeed = new JLabel();
	
	public StatsPanel(WorldModel wm){
		ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();
	    setLayout(layout);
	    layout.addRow("a.......ab.b");
		layout.addRow("c.......cd.d");
		layout.addRow("e.......ef.f");
	
		JLabel lblScore = new JLabel();
		JLabel lblCntEaten = new JLabel();
		JLabel lblSpeed = new JLabel();
		
		add(lblScore, "a");
		add(lbScore, "b");
		add(lblCntEaten, "c");
		add(lbCntEaten, "d");
		add(new JLabel("Vitesse :"), "e");
		add(lbSpeed, "f");
		    
	    StatsWorldObserver wo = new StatsWorldObserver(this, wm);
	    wm.addObserver(wo);
	    
	    setSize(230, 200);
	    setPreferredSize(getSize());
	    setBackground(Color.GRAY);
	}
  /*
	public void setText(){
		bIdat = ResourceBundle.getBundle("lang.Idat", wm.getLocale());
		
		lblLang.setText(bIdat.getString("language")+" : ");
		lblSpeed.setText(bIdat.getString("speed")+" : ");
		lblColor.setText(bIdat.getString("color")+" : ");
		
		comboModel.update();
		boxLang.revalidate();
		
		boxColor.removeAllItems();
		boxColor.addItem(bIdat.getString("blue"));
		boxColor.addItem(bIdat.getString("red"));
		boxColor.addItem(bIdat.getString("pink"));    
		boxColor.revalidate();
	}
	*/
}
