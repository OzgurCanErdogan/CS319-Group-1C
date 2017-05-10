import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;

class CustomMouseListener2 implements MouseListener{
  MenuManager menu;

  public CustomMouseListener2(MenuManager m){
    menu = m;
  }
  public void mouseClicked(MouseEvent e){
    if( e.getSource() == menu.getModeBackButton()){
      menu.changePlace("main");
      menu.setMode();
    }else if( e.getSource() == menu.getSettingsBackButton()){
      menu.changePlace("main");
    }else if( e.getSource() == menu.getApplyButton()){
      menu.setColor();
      menu.setVolume();
    }else if( e.getSource() == menu.getMenuNewGameButton()){
      menu.changePlace("newGame");
    }
    else if( e.getSource() == menu.getMenuSettingsButton()){
      menu.changePlace("settings");
    }
    else if( e.getSource() == menu.getMenuModeSettingsButton()){
      menu.changePlace("modeSettings");
    }else if( e.getSource() == menu.getMenuCreditsButton()){
      menu.changePlace("credits");
    }else if( e.getSource() == menu.getMenuHelpButton()){
      menu.changePlace("help");
    }
    else if( e.getSource() == menu.getMenuQuitButton()){
      System.exit(0);
    }else if( e.getSource() == menu.getCreditsBackButton()){
      menu.changePlace("main");
    }else if( e.getSource() == menu.getHelpBackButton()){
      menu.changePlace("main");
    }
  }
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
}
