import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuManager extends JFrame{
	public static final int height = 600;
	public static final int width = 800;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private ModeSettings modeSettings;
	private MainMenu mainMenu;
	private GameManager gameManager;
	private SettingsMenu settings;
	private CustomMouseListener2 mouseListener;


	public MenuManager(){
		cardLayout = new CardLayout();
		mouseListener = new CustomMouseListener2(this);
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setLayout( cardLayout);
		add( mainPanel);

		// Main Menu
		mainMenu = new MainMenu( mouseListener);
		mainMenu.setSize( new Dimension(width, height));
		mainPanel.add("main", mainMenu);

		// Settings Menu
		settings = new SettingsMenu( mouseListener);
		settings.setSize(new Dimension( width, height));
		mainPanel.add("settings", settings);

		// New Game
		gameManager = new GameManager();
		gameManager.setPreferredSize( new Dimension( width, height));
		mainPanel.add("newGame", gameManager);

		//Mode Settings
		modeSettings = new ModeSettings(mouseListener);
		modeSettings.setSize( new Dimension( width, height));
		mainPanel.add("modeSettings", modeSettings);

	}
	public void changePlace(String place){
		cardLayout.show(mainPanel, place);
	}
	public JButton getModeBackButton(){
		return modeSettings.getBackButton();
	}
	public int getMode(){
		return modeSettings.getMode();
	}
	public void setMode(){
		gameManager.setMode( getMode());
	}
	public JButton getSettingsBackButton(){
		return settings.getBackButton();
	}
	public JButton getApplyButton(){
		return settings.getApplyButton();
	}
	public void setColor(){
		gameManager.setColor( settings.getColor());
	}
	public void setVolume(){
		gameManager.setVolume( settings.getVolume());
	}
	public JButton getMenuNewGameButton(){
		return mainMenu.getNewGameButton();
	}
	public JButton getMenuHelpButton(){
		return mainMenu.getHelpButton();
	}
	public JButton getMenuSettingsButton(){
		return mainMenu.getSettingsButton();
	}
	public JButton getMenuModeSettingsButton(){
		return mainMenu.getModeSettingsButton();
	}
	public JButton getMenuCreditsButton(){
		return mainMenu.getCreditsButton();
	}
	public JButton getMenuQuitButton(){
		return mainMenu.getQuitButton();
	}
	// Main Method
	public static void main(String args[]){
		new MenuManager();
	}
}
