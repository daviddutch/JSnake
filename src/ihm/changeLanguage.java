package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeLanguage implements ActionListener {
  private OptionDialog my;
  
    public changeLanguage(OptionDialog optionDialog) {
      my=optionDialog;
    } 

    public void actionPerformed(ActionEvent e) {
      my.changeLang(my.boxLang.getSelectedIndex());
      //System.out.println("ActionListener : action sur "+my.boxLang.getSelectedItem()+ "index ("+my.boxLang.getSelectedIndex()+")");    
    }   

}
