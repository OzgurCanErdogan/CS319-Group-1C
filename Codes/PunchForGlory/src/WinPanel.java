import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class WinPanel extends JPanel{
CustomMouseListener mouseListener;
Image winImage;
  WinPanel( CustomMouseListener mouselistener){
    mouseListener = mouselistener;

    URL mapURL = getClass().getClassLoader().getResource("winEnd.jpg");
    ImageIcon mapIcon = new ImageIcon(mapURL);
    winImage = mapIcon.getImage();
  }
  //@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(winImage, 0,0,800,600,null);

	}
}
