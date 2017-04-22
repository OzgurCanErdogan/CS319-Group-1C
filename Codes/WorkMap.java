import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;

public class WorkMap extends JPanel{
	Image workImage;
	JButton back;
	CardLayout cardLayout;
	JPanel mainPanel;
	WorkMap(JPanel panel, CardLayout cL){
		mainPanel = panel;
		cardLayout = cL;
		setLayout(null);
		URL mapURL = getClass().getClassLoader().getResource("work.png");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		workImage = mapIcon.getImage(); 
		JLabel text = new JLabel("Money needed for living. Therefore start working for making money.");
		JButton work = new JButton("Work");
		text.setBounds(100,200, 600, 250);
		work.setBounds(200,450, 100,50); 
		add(text);
		add(work);
		back = new JButton("Back");
		back.setBounds( 350, 450, 100, 50);
		back.addMouseListener(new CustomMouseListener());
		add(back);
		
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(workImage, 0,0,800,280,null);
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
