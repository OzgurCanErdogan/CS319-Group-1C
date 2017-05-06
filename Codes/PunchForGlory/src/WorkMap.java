import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;

public class WorkMap extends JPanel{
	Image workImage;
	JButton work;
	JButton back;
	CustomMouseListener mouseListener;
	WorkMap( CustomMouseListener mouselistener){
		setLayout(null);
		URL mapURL = getClass().getClassLoader().getResource("work.png");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		workImage = mapIcon.getImage(); 
		mouseListener = mouselistener;
		
		JLabel text = new JLabel("Money needed for living. Therefore start working for making money.");
		text.setBounds(100,200, 600, 250);
		
		work = new JButton("Work");
		work.setBounds(200,450, 100,50); 
		
		back = new JButton("Back");
		back.setBounds( 350, 450, 100, 50);
		
		back.addMouseListener(mouseListener);
		work.addMouseListener(mouseListener);
		
		add(text);
		add(work);
		add(back);
		
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(workImage, 0,0,800,280,null);
	}
	public JButton getBackButton(){
		return back;
	}
	public JButton getWorkButton(){
		return work;
	}
}
