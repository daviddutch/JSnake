package ihm;

import java.awt.*;
import java.util.Locale;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.*;

import world.WorldModel;

public class OptionDialog extends JDialog {
  
  WorldModel wm;
  ResourceBundle bIdat;

  Box panel = Box.createVerticalBox();
  
  JLabel lblTitle     = new JLabel("Snake 1.0");
  JLabel lblLang      = new JLabel();
  JLabel lblSpeed     = new JLabel();
  JLabel lblColor     = new JLabel();
  
  ImageIcon imgSnake;
  
  JButton btGame      = new JButton("Start game");
  
  JComboBox boxLang = new JComboBox();
  JComboBox boxColor = new JComboBox();
  
  
  public OptionDialog(WorldModel wm){
    this.wm = wm;
    this.wm.addObserver((Observer) new OptionDialogObserver(this));
       
    panel.add(Box.createVerticalGlue());
    panel.setMaximumSize(panel.getPreferredSize());
    
    imgSnake = new ImageIcon("images/logoSnake.png");
        
    boxLang.setPreferredSize(new Dimension(100,20));
    boxLang.setMaximumSize(boxLang.getPreferredSize());
    boxLang.addActionListener(new changeLanguage(this));
    
    boxColor.setPreferredSize(new Dimension(100,20));
    boxColor.setMaximumSize(boxColor.getPreferredSize());
    //boxColor.addActionListener(new changeColor(this));

    setText();
    
    setTitle("Snake Game - Settings");
    setSize(800, 600);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    //--- Place la fenêtre de l'application
    setLocation((screenSize.width - frameSize.width) / 2,
    (screenSize.height - frameSize.height) / 5);
    
    panel.add(lblTitle);
    panel.add(lblLang);
    panel.add(boxLang);
    panel.add(lblSpeed);
    panel.add(lblColor);
    panel.add(btGame);

    getContentPane().add(panel);
    
  }
  
  public void setText(){
    bIdat = ResourceBundle.getBundle("lang.Idat", wm.getLocale());
    
    lblLang.setText(bIdat.getString("language")+" : ");
    lblSpeed.setText(bIdat.getString("speed")+" : ");
    lblColor.setText(bIdat.getString("color")+" : ");
    
    boxLang.removeAllItems();
    boxLang.removeAll();
    boxLang.addItem(bIdat.getString("french"));
    boxLang.addItem(bIdat.getString("english"));
    boxLang.addItem(bIdat.getString("italian"));
    
  }

  public void changeLang(int i) {
    System.out.println("idLang:"+i);
    switch(i){
      case 0 :
        wm.setLocale(new Locale((Locale.FRENCH.toString())));
        break;
      case 1 :
        wm.setLocale(new Locale((Locale.ENGLISH.toString())));
        break;
      case 2 :
        wm.setLocale(new Locale((Locale.ITALIAN.toString())));
        break;
      default:
        break;
    }
    //setText();
  }
}
