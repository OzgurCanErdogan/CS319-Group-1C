import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class Map extends JPanel{
	Image mapImage;
	public Map(){
		URL mapURL = getClass().getClassLoader().getResource("map.jpeg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		mapImage = mapIcon.getImage(); 

	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(mapImage, 0,0,800,580,null);
		
	}

}
