package ihm;

import java.util.Observable;
import java.util.Observer;

import world.WorldModel;


public class StatsPanelObserver implements Observer {
	StatsPanel sp;
	
	public StatsPanelObserver(StatsPanel sp, WorldModel wm) {
		this.sp = sp;
		configChanged(wm); 
	}
	
	@Override
	public void update(Observable o, Object event) {
		WorldModel wm = (WorldModel) o;
	    WorldModel.WorldEvents what = (WorldModel.WorldEvents) event;
	    switch (what){
	      case CONFIG_CHANGED:
	        configChanged(wm);
	        break;
	      case STEP_FORWARD:
	        stepForward(wm);
	        break;
	    }
	  }
	
	  private void configChanged(WorldModel wm){
		  sp.setText();
		  sp.lbScore.setText(""+wm.getScore());
		  sp.lbCntEaten.setText(""+wm.getCntEaten());
		  sp.lbSpeed.setText(""+wm.getSpeed());
	  }
	  
	  private void stepForward(WorldModel wm){
	    
	  }

}
