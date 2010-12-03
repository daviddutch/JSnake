package ihm;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;

import world.WorldModel;

public class LanguagesComboModel extends DefaultComboBoxModel {
  private List<String> languages = new ArrayList<String>(3);
  private WorldModel model;

  public LanguagesComboModel(WorldModel model) {
    super();
    
    this.model = model;
  }

  @Override
  public Object getElementAt(int arg0) {
    return languages.get(arg0);
  }

  @Override
  public int getSize() {
    return languages.size();
  }
  
  public void update(){
    ResourceBundle bIdat = ResourceBundle.getBundle("lang.Idat", model.getLocale());
    
    languages.clear();
    languages.add(bIdat.getString("french"));
    languages.add(bIdat.getString("english"));
    languages.add(bIdat.getString("italian"));
    
    fireContentsChanged(this, 0, 3);
  }
}
