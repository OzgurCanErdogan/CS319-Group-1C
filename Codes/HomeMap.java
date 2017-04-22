import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;

public class HomeMap extends JPanel{
	Image nightImage;
	JButton back;
	CardLayout cardLayout;
	JPanel mainPanel;
	HomeMap(JPanel panel, CardLayout cL){
		mainPanel = panel;
		cardLayout = cL;
		setLayout(null);
		URL mapURL = getClass().getClassLoader().getResource("night.jpeg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		nightImage = mapIcon.getImage(); 
		JLabel text = new JLabel("After a long day, best thing is a good sleep. You need rest for the next day.");
		JButton sleep = new JButton("Sleep");
		text.setBounds(100,200, 600, 250);
		sleep.setBounds(200,450, 100,50); 
		add(text);
		add(sleep);
		back = new JButton("Back");
		back.setBounds( 350, 450, 100, 50);
		back.addMouseListener(new CustomMouseListener());
		add(back);
		
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(nightImage, 0,0,800,280,null);
	}
	class CustomMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e){
			if( e.getSource() == back){
				cardLayout.show(mainPanel, "map");
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	}
}
