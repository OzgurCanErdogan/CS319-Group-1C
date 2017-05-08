import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class MainMenu extends JPanel{
	JButton newGame;
	JButton help;
	JButton settings;
	JButton modeSettings;
	JButton credits;
	JButton quit;
	CustomMouseListener2 mouse;
	Image boxer;

	public MainMenu( CustomMouseListener2 mouseListener){
		mouse = mouseListener;
		setLayout( null);

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
	public JButton getNewGameButton(){
		return newGame;
	}
	public JButton getHelpButton(){
		return help;
	}
	public JButton getSettingsButton(){
		return settings;
	}
	public JButton getModeSettingsButton(){
		return modeSettings;
	}
	public JButton getCreditsButton(){
		return credits;
	}
	public JButton getQuitButton(){
		return quit;
	}
}
