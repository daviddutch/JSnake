package ihm;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import world.WorldModel;

import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

public class StatsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private WorldModel wm;
	
	private ResourceBundle bIdat;
	private JLabel lbScoreText = new JLabel();
	private JLabel lbCntEatenText = new JLabel();
	private JLabel lbSpeedText = new JLabel();
	JLabel lbScore = new JLabel();
	JLabel lbCntEaten = new JLabel();
	JLabel lbSpeed = new JLabel();
	/**
	 * Constructor method
	 * Initialize StatsPanel and its contents
	 */
	public StatsPanel(WorldModel wm){
	    this.wm = wm;
	    

	    lbScoreText.setPreferredSize(new Dimension(90, 20));
	    lbCntEatenText.setPreferredSize(new Dimension(90, 20));
	    lbSpeedText.setPreferredSize(new Dimension(90, 20));
	    //lbScoreText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	    ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();
	    setLayout(layout);
	    layout.addRow("a.......ab.b");
	    layout.addRow("c.......cd.d");
	    layout.addRow("e.......ef.f");
	    add(lbScoreText, "a");
	    add(lbScore, "b");
	    add(lbCntEatenText, "c");
	    add(lbCntEaten, "d");
	    add(lbSpeedText, "e");
	    add(lbSpeed, "f");
	    setText();
		
	    StatsPanelObserver wo = new StatsPanelObserver(this, wm);
	    wm.addObserver(wo);
	    
	    setSize(200, 80);
	    setPreferredSize(getSize());
	    setBackground(Color.WHITE);
	}
	/**
	 *	Set text of labels according to the location
	 */
	public void setText(){
		bIdat = ResourceBundle.getBundle("lang.Idat", wm.getLocale());
		lbScoreText.setText(bIdat.getString("score")+": ");
		lbCntEatenText.setText(bIdat.getString("cntEaten")+": ");
		lbSpeedText.setText(bIdat.getString("speed")+": ");
	}
}
