package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionDialogAction implements ActionListener, ChangeListener{
  private OptionDialog my;
  
    public OptionDialogAction(OptionDialog optionDialog) {
      my=optionDialog;
    } 

    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand()=="color"){
        //my.changeColor(my.boxLang.getSelectedIndex());
      }else if(e.getActionCommand()=="lang"){
        if(my.boxLang.getSelectedIndex()>=0)
          my.changeLang(my.boxLang.getSelectedIndex());
      }else if(e.getActionCommand()=="start"){
        my.startGame();
      }
      //System.out.println("ActionListener : action sur "+my.boxLang.getSelectedItem()+ "index ("+my.boxLang.getSelectedIndex()+")");    
    }

    public void stateChanged(ChangeEvent e) {
      //System.out.println(((JSlider)e.getSource()).getValue());
      my.changeSpeed(((JSlider)e.getSource()).getValue());
      
    }   

}
