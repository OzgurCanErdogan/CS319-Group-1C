import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;
import java.net.URL;

public class MainMenu extends JPanel{
	JPanel mainPanel;
	CardLayout cardLayout;
	JButton newGame;
	JButton help;
	JButton settings;
	JButton modeSettings;
	JButton credits;
	JButton quit;	
	CustomMouseListener mouse;
	Image boxer;
	public MainMenu( JPanel panel, CardLayout cl){
		mainPanel = panel;
		cardLayout = cl;
		setLayout( null);
		mouse = new CustomMouseListener();			


		URL boxerURL = getClass().getClassLoader().getResource("boxer.png");
		ImageIcon boxerIcon = new ImageIcon(boxerURL);
		boxer = boxerIcon.getImage(); 

		newGame = new JButton("New Game");
		help = new JButton("Help");
		settings = new JButton("Settings");
		modeSettings = new JButton("Mode Settings");
		credits = new JButton("Credits");
		quit = new JButton("Quit");

		newGame.setBounds(200, 200, 150,50);
		help.setBounds(450,200,150,50);
		settings.setBounds(200, 300, 150,50);
		modeSettings.setBounds(450,300,150,50);
		credits.setBounds(200,400,150,50);
		quit.setBounds(450,400,150,50);

		add(newGame);
		add(help);
		add(settings);
		add(modeSettings);
		add(credits);
		add(quit);
	
		newGame.addMouseListener( mouse);
		help.addMouseListener( mouse);
		settings.addMouseListener( mouse);
		modeSettings.addMouseListener( mouse);
		credits.addMouseListener( mouse);
		quit.addMouseListener( mouse);
	}

	//@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(boxer, 325,0,150,200,null);
	}
	
	class CustomMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e){
			if( e.getSource() == newGame){
				cardLayout.show(mainPanel, "newGame");
			}
			else if( e.getSource() == help){
			}
			else if( e.getSource() == settings){

				cardLayout.show(mainPanel, "settings");
			}
			else if( e.getSource() == modeSettings){
				cardLayout.show(mainPanel, "modeSettings");
			}
			else if( e.getSource() == credits){
			}
			else if( e.getSource() == quit){
				System.exit(0);
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	
	}
}
