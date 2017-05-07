import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;

public class HomeMap extends JPanel{
	Image nightImage;
	JButton back;
	JButton sleep;
	CustomMouseListener mouseListener;
	HomeMap(CustomMouseListener mouselistener){
		setLayout(null);
		URL mapURL = getClass().getClassLoader().getResource("night.jpeg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		nightImage = mapIcon.getImage(); 
		mouseListener = mouselistener;

		JLabel text = new JLabel("After a long day, best thing is a good sleep. You need rest for the next day.");
		text.setBounds(100,200, 600, 250);
		
		sleep = new JButton("Sleep");
		sleep.setBounds(200,450, 100,50); 
		
		
		back = new JButton("Back");
		back.setBounds( 350, 450, 100, 50);
		
		back.addMouseListener(mouseListener);
		sleep.addMouseListener(mouseListener);
		
		
		add(text);
		add(sleep);
		add(back);
		
	}
	//@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(nightImage, 0,0,800,280,null);
	}
	public JButton getBackButton(){
		return back;
	}
	public JButton getSleepButton(){
		return sleep;
	}
}
