package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameViewAction implements ActionListener{
  private GameView my;
  
  public GameViewAction(GameView gameview) {
    my=gameview;
  } 

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand()=="pause"){
      my.setPause();
    }else if(e.getActionCommand()=="play"){
      my.setPlay();
    }else if(e.getActionCommand()=="stop"){
      my.setStop();
    }
  }

}
