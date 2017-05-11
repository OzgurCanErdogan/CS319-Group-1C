import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class LosePanel extends JPanel{
CustomMouseListener mouseListener;
Image loseImage;
  LosePanel( CustomMouseListener mouselistener){
    mouseListener = mouselistener;

    URL mapURL = getClass().getClassLoader().getResource("loseEnd.jpg");
    ImageIcon mapIcon = new ImageIcon(mapURL);
    loseImage = mapIcon.getImage();
  }
  //@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(loseImage, 0,0,800,600,null);

	}
}
