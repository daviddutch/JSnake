package ihm;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
  
  LanguagesComboModel comboModel;
  
  JSlider sliderSpeed;
  
  public OptionDialog(WorldModel wm){
    OptionDialogAction action = new OptionDialogAction(this);
    this.wm = wm;
    this.wm.addObserver((Observer) new OptionDialogObserver(this));
    
    comboModel= new LanguagesComboModel(wm);
       
    panel.add(Box.createVerticalGlue());
    panel.setMaximumSize(panel.getPreferredSize());
    
    imgSnake = new ImageIcon("images/logoSnake.png");
   
    boxLang.setModel(comboModel);
    boxLang.setPreferredSize(new Dimension(100,20));
    boxLang.setMaximumSize(boxLang.getPreferredSize());
    boxLang.addActionListener(action);
    boxLang.setActionCommand("lang");
       
    boxColor.setPreferredSize(new Dimension(100,20));
    boxColor.setMaximumSize(boxColor.getPreferredSize());
    boxColor.addActionListener(action);
    boxColor.setActionCommand("color");

    sliderSpeed = new JSlider();
    sliderSpeed.setPreferredSize(new Dimension(200, 60));
    sliderSpeed.setMinimumSize(new Dimension(150, 60));
    sliderSpeed.setMaximumSize(new Dimension(200, 60));
    sliderSpeed.setMinimum(1);
    sliderSpeed.setMaximum(10);
    sliderSpeed.setValue(wm.getSpeed());
    sliderSpeed.setMajorTickSpacing(2);
    sliderSpeed.setMinorTickSpacing(1);
    sliderSpeed.setPaintTicks(true);
    sliderSpeed.setPaintLabels(true);
    sliderSpeed.setSnapToTicks(true);
    sliderSpeed.addChangeListener(action);

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
    panel.add(sliderSpeed);
    panel.add(lblColor);
    panel.add(boxColor);
    panel.add(btGame);
    
    getContentPane().add(panel);
    
  }
  
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

  public void changeLang(int i) {
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
  }

  public void changeSpeed(int value) {
    wm.setSpeed(value);    
  }
}
