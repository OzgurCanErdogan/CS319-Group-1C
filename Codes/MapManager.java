import java.awt.*;  
import javax.swing.*;  
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;

public class MapManager{  
	public static final int height = 600;
	public static final int width = 800;
	JLabel mousePoint;
	JFrame window;
	CardLayout cardLayout;
	JPanel mainPanel;
	public MapManager(){
		window = new JFrame();
		window.setSize(width, height);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout( new BorderLayout());
		mainPanel = new JPanel();
		window.add(mainPanel, BorderLayout.CENTER);


		// boxer properties
		JPanel properties = new JPanel();
		FlowLayout flow = new FlowLayout(5);
		properties.setLayout( flow);
		flow.setHgap(25);
		properties.setSize(20,800);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		JLabel str = new JLabel("Strength");
		str.setPreferredSize(new Dimension(100,40));
		str.setBorder(border);
		JLabel agi = new JLabel("Agility");
		agi.setPreferredSize(new Dimension(100,40));
		agi.setBorder(border);
		JLabel vit = new JLabel("Vitality");
		vit.setPreferredSize(new Dimension(100,40));
		vit.setBorder(border);
		JLabel exp = new JLabel("Experience");
		exp.setPreferredSize(new Dimension(100,40));
		exp.setBorder(border);
		JLabel time = new JLabel("Time");
		time.setPreferredSize(new Dimension(100,20));		
		properties.add(str);
		properties.add(agi);
		properties.add(vit);
		properties.add(exp);
		properties.add(time);		


		window.add(properties, BorderLayout.NORTH);
		
		// general map adding
		Map map = new Map();
		map.setPreferredSize( new Dimension(width, height));
		map.addMouseListener( new CustomMouseListener());
		cardLayout = new CardLayout();
		mainPanel.setLayout( cardLayout);
		//Container cp = window.getContentPane();
		//cp.setLayout(new BorderLayout());
		//cp.add( map,BorderLayout.CENTER);
		mainPanel.add("map",map);
		window.pack();
		//cp = window.getContentPane();
		mousePoint = new JLabel();
		mousePoint.setSize(50,800);
		//cp.add(mousePoint, BorderLayout.SOUTH);
		window.add(mousePoint, BorderLayout.SOUTH);
		window.pack();
		
		//adding home map
		HomeMap home = new HomeMap(mainPanel,cardLayout);
		home.setPreferredSize( new Dimension(width,height));
		mainPanel.add("home",home);

		//adding work map
		WorkMap work = new WorkMap( mainPanel, cardLayout);
		work.setPreferredSize( new Dimension(width,height));
		mainPanel.add("work",work);

		//adding gym map
		GymMap gym = new GymMap( mainPanel, cardLayout);
		gym.setPreferredSize( new Dimension(width,height));
		mainPanel.add("gym",gym);

	}
	class CustomMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e){
			int x = e.getX();
			int y = e.getY();	
					
			if( x < 350 && x > 320 && y < 150 && y > 110){
				// home
				mousePoint.setText("Mouse position is home");
				cardLayout.show(mainPanel, "home");
				
			}else if( x < 160 && x> 100 && y < 310 && y> 260){
				// work
				mousePoint.setText("Mouse position is work");
				cardLayout.show(mainPanel,"work");			

			}else if( x < 330 && x> 280 && y < 310 && y > 260 ){
				// arena
				mousePoint.setText("Mouse position is arena");
			}else if( x < 580 && x > 530 && y < 305 && y > 245){
				// gym	
				mousePoint.setText("Mouse position is gym");
				cardLayout.show(mainPanel, "gym");
			}else if( x < 660 && x > 605 && y < 110 && y > 55 ){
				// street
				mousePoint.setText("Mouse position is street");
			}else{
				mousePoint.setText("Mouse position X: " + x+ ", Y: " + y);
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	}

	public static void main(String[] args){
		new MapManager();
	}
}  
