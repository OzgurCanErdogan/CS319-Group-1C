import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;
public class GymMap extends JPanel{
	//Image gymImage;
	JButton back;
	CardLayout cardLayout;
	JPanel mainPanel;
	GymMap(JPanel panel, CardLayout cL){
		mainPanel = panel;
		cardLayout = cL;
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		//URL mapURL = getClass().getClassLoader().getResource("gym.png");
		//ImageIcon mapIcon = new ImageIcon(mapURL);
		JLabel lift = new JLabel("Weightlifting");
		lift.setBounds(50,100,250,50);
		lift.setBorder(border);
		JLabel run = new JLabel("Running on Treadmill");
		run.setBounds(50,200,250,50);
		run.setBorder(border);
		JLabel box = new JLabel("Shadow Boxing");
		box.setBounds(50,300,250,50);
		box.setBorder(border);
		JButton doIt1 = new JButton("Do It");
		doIt1.setBounds(300,100,150,50);
		JButton doIt2 = new JButton("Do It");
		doIt2.setBounds(300,200,150,50);
		JButton doIt3 = new JButton("Do It");
		doIt3.setBounds(300,300,150,50);
		JButton back = new JButton("Back");
		back.setBounds(100,400,150,50);
		add(lift);
		add(run);
		add(box);
		add(doIt1);
		add(doIt2);
		add(doIt3);
		back.addMouseListener( new CustomMouseListener());
		add(back);
	}
	/*@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(gymImage, 0,0,800,200,null);
	}*/
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
