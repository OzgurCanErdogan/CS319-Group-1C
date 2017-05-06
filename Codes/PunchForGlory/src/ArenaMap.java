import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;

public class ArenaMap extends JPanel{
	// images initialization
	private Image arenaImage;
	private Image boxer;
	private Image opponent;
	
	// buttons initialization
	private JButton skill1;
	private JButton skill2;
	private JButton skill3;
	private JButton dodge;

	// initialize mouse listener
	private CustomMouseListener mouseListener;
	
	// initialize properties of opponent and their labels
	private int health;
	private int oppHealth;
	private JLabel healthLabel;
	private JLabel oppHealthLabel;
	private int oppStr;
	private int oppAgi;
	private int oppVit;

	// initialize attack limit
	private int attackTime;

	ArenaMap( CustomMouseListener mouselistener){
		// draw the background image
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		URL mapURL = getClass().getClassLoader().getResource("ring.jpg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		arenaImage = mapIcon.getImage();
		mapURL = getClass().getClassLoader().getResource("boxer.png");
		mapIcon = new ImageIcon(mapURL);
		boxer = mapIcon.getImage();
		mapURL = getClass().getClassLoader().getResource("opponent.png");
		mapIcon = new ImageIcon(mapURL);
		opponent = mapIcon.getImage();

		
		// assign mouse listener from parameter
		mouseListener = mouselistener;
		
		// assign number of attack limit
		attackTime = 3;

		// assign health and and labels
		health = 100;
		String temp = "Health: " + health;
		healthLabel = new JLabel( temp);
		healthLabel.setBounds(0,0,250,50);
		healthLabel.setBorder(border);
		healthLabel.setBackground( Color.GRAY);
		healthLabel.setOpaque(true);
		
		// assign properties and health of opponent
		oppStr = 5;
		oppAgi = 5;
		oppVit = 5;
		oppHealth = 100;
		temp = "Health: " + oppHealth;
		oppHealthLabel = new JLabel(temp);
		oppHealthLabel.setBounds(550,0,250,50);
		oppHealthLabel.setBorder(border);
		oppHealthLabel.setBackground( Color.GRAY);
		oppHealthLabel.setOpaque(true);

		// add health labels to panel
		add(healthLabel);
		add(oppHealthLabel);

		// assign skill buttons
		skill1 = new JButton("Blow");
		skill2 = new JButton("Fist");
		skill3 = new JButton("Uppercut");
		dodge = new JButton("Dodge");
		
		// give bounds to buttons
		skill1.setBounds( 50, 475, 100, 50);
		skill2.setBounds( 150, 475, 100, 50);
		skill3.setBounds( 250, 475, 100, 50);
		dodge.setBounds( 350, 475, 100, 50);
		
		// add mouse listener to buttons
		skill1.addMouseListener(mouseListener);
		skill2.addMouseListener(mouseListener);
		skill3.addMouseListener(mouseListener);
		dodge.addMouseListener(mouseListener);

		// add buttons to panel
		add(skill1);
		add(skill2);
		add(skill3);
		add(dodge);
	}
	// draw images
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(54,111,135));
		g.drawImage(arenaImage, 0,0,800,475,null);
		g.drawImage(boxer, 75,150,200,350,null);
		g.drawImage(opponent, 575,150,200,350,null);
		g.fillRect(0,475, 800, 125);
		
	}
	// get button objects
	public JButton getSkill1Button(){
		return skill1;
	}
	public JButton getSkill2Button(){
		return skill2;
	}
	public JButton getSkill3Button(){
		return skill3;
	}
	public JButton getDodgeButton(){
		return dodge;
	}
	// set health value and set health text
	public void setHealth( int value){
		health = value;
		String temp = "Health: " + health;
		healthLabel.setText(temp);
	}
	// get health of boxer
	public int getHealth(){
		return health;
	}
	// decrese health of boxer as parameter
	public void updateHealth( int value){
		health = health - value;
		String temp = "Health: " + health;
		healthLabel.setText(temp);
	}
	// decrease health of opponent as parameter
	public void updateOpponentHealth( int value){
		oppHealth = oppHealth - value;
		String temp = "Health: " + oppHealth;
		oppHealthLabel.setText(temp);
	}
	// check boxer or opponent's health become zero
	public boolean isFinished(){
		if( health <= 1 || oppHealth <= 1)
			return true;
		else 
			return false;
	}
	// control who wins
	public boolean isWin(){
		if( health <= 1)
			return false;
		else 
			return true;
	}
	// reset properties of opponent
	public void reset( int str, int agi, int vit){
		oppHealth = 100;
		String temp = "Health: " + oppHealth;
		oppHealthLabel.setText(temp);
		
		oppStr = (int)(str * 0.9);
		oppAgi = (int)(agi * 1.2);
		oppVit = (int)(vit * 1.5);
	}
	// control whether boxer has finish his 3 attack round
	public boolean attack(){
		attackTime = attackTime - 1;
		if( attackTime == 0){
			attackTime = 3;
			return false;
		}
		return true;
	}
	// decrease boxer's health according to which attack opponent used
	public void oppAttack(	int skill){
		if( skill == 0 ){
			int attack = oppStr * 1;
			updateHealth( attack);
		}else if( skill == 1){
			int attack = oppStr * 2 + oppAgi * 1;
			updateHealth(attack);
		}else{
			int attack = oppStr * 3 + oppAgi * 2;
			updateHealth( attack);
		}
	}
}
