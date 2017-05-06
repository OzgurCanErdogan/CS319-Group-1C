import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuManager extends JFrame{
	public static final int height = 600;
	public static final int width = 800;
	CardLayout cardLayout;
	JPanel mainPanel;

	public MenuManager(){
		cardLayout = new CardLayout();


		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setLayout( cardLayout);
		add( mainPanel);

		// Main Menu 
		MainMenu mainMenu = new MainMenu(mainPanel, cardLayout);
		mainMenu.setSize( new Dimension(width, height));
		mainPanel.add("main", mainMenu);

		// Settings Menu
		SettingsMenu settings = new SettingsMenu( mainPanel, cardLayout);
		settings.setSize(new Dimension( width, height));
		mainPanel.add("settings", settings);

		// New Game
		GameManager gameManager = new GameManager();
		gameManager.setPreferredSize( new Dimension( width, height));
		mainPanel.add("newGame", gameManager);

		//Mode Settings
		ModeSettings modeSettings = new ModeSettings(mainPanel, cardLayout);
		modeSettings.setSize( new Dimension( width, height));
		mainPanel.add("modeSettings", modeSettings);
	}

	public static void main(String args[]){
		new MenuManager();
	}

}
