import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;

public class GymMap extends JPanel{
	JButton back;
	Image gymImage;
	JButton doIt1;
	JButton doIt2;
	JButton doIt3;
	CustomMouseListener mouseListener;
	GymMap( CustomMouseListener mouselistener){
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		URL mapURL = getClass().getClassLoader().getResource("gym.jpeg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		gymImage = mapIcon.getImage();
		mouseListener = mouselistener;
		
		
		JLabel lift = new JLabel("Weightlifting");
		lift.setBounds(50,100,250,50);
		lift.setBorder(border);
		lift.setBackground( Color.GRAY);
		lift.setOpaque(true);
		
		JLabel run = new JLabel("Running on Treadmill");
		run.setBounds(50,200,250,50);
		run.setBorder(border);
		run.setBackground( Color.GRAY);
		run.setOpaque(true);
		
		JLabel box = new JLabel("Shadow Boxing");
		box.setBounds(50,300,250,50);
		box.setBorder(border);
		box.setBackground( Color.GRAY);
		box.setOpaque(true);
		
		doIt1 = new JButton("Do It");
		doIt1.setBounds(300,100,150,50);
		doIt2 = new JButton("Do It");
		doIt2.setBounds(300,200,150,50);
		doIt3 = new JButton("Do It");
		doIt3.setBounds(300,300,150,50);
		back = new JButton("Back");
		back.setBounds(100,400,150,50);
		
		back.addMouseListener(mouseListener);
		doIt1.addMouseListener(mouseListener);
		doIt2.addMouseListener(mouseListener);
		doIt3.addMouseListener(mouseListener);
		
		add(lift);
		add(run);
		add(box);
		add(doIt1);
		add(doIt2);
		add(doIt3);
		add(back);
	}
	//@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setOpaque(false);
		setBackground(Color.WHITE);
		g.drawImage(gymImage, 0,0,800,600,null);
	}
	public JButton getBackButton(){
		return back;
	}
	public JButton getDoIt1Button(){
		return doIt1;
	}
	public JButton getDoIt2Button(){
		return doIt2;
	}
	public JButton getDoIt3Button(){
		return doIt3;
	}
}
