import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ArenaMap extends JPanel{
	// images initialization
	private Image arenaImage;
	private Image boxer;
	private Image opponent;
	private Image bam;

	// buttons initialization
	private JButton skill1;
	private JButton skill2;
	private JButton skill3;
	private JButton dodge;

	// Label initialization
	private JLabel fightLabel;
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

	private boolean boxerEffect, opponentEffect;

	ArenaMap( CustomMouseListener mouselistener){

		boxerEffect = false;
		opponentEffect = false;

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

		mapURL = getClass().getClassLoader().getResource("bam.png");
		mapIcon = new ImageIcon( mapURL);
		bam = mapIcon.getImage();



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
		fightLabel = new JLabel("Your opponent is ready. What about you?");

		// give bounds to buttons
		skill1.setBounds( 50, 475, 100, 50);
		skill2.setBounds( 150, 475, 100, 50);
		skill3.setBounds( 250, 475, 100, 50);
		dodge.setBounds( 350, 475, 100, 50);
		fightLabel.setBounds( 500, 475, 300, 50);

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
		add(fightLabel);


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
		if( opponentEffect)
			g.drawImage( bam, 550, 180, 100, 100, null);
		else if( boxerEffect)
			g.drawImage( bam, 180, 180, 100, 100, null);

	}

	public void setSkill1Name(String newSkill) {
		skill1.setText(newSkill);
	}
	public void setSkill2Name(String newSkill) {
		skill2.setText(newSkill);
	}
	public void setSkill3Name(String newSkill) {
		skill3.setText(newSkill);
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
		fightLabel.setText( "Your opponent is ready. What about you?");
		opponentEffect = false;
		boxerEffect = false;
		repaint();
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
	public int oppAttack(	int skill){
		int attack;
		if( skill == 0 ){
			attack = oppStr * 1;
			updateHealth( attack);
		}else if( skill == 1){
			attack = oppStr * 2 + oppAgi * 1;
			updateHealth(attack);
		}else{
			attack = oppStr * 3 + oppAgi * 2;
			updateHealth( attack);
		}
		return attack;
	}
	public void setFightLabel( String text){
		fightLabel.setText( text);
	}
	public void boxerAttackEffect(){
		boxerEffect = false;
		opponentEffect = true;
		repaint();
	}
	public void opponentAttackEffect(){
		opponentEffect = false;
		boxerEffect = true;
		repaint();
	}
}
