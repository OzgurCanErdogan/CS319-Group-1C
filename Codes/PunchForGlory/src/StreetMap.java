import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;
public class StreetMap extends JPanel{
	//Image gymImage;
	private Image arenaImage;
	private Image boxer;
	private Image opponent;
	private Image bam;


	private JButton skill1;
	private JButton skill2;
	private JButton skill3;
	private JButton dodge;
	private JLabel fightLabel;

	private CustomMouseListener mouseListener;
	
	private int health;
	private int oppHealth;
	private JLabel healthLabel;
	private JLabel oppHealthLabel;

	private int attackTime;

	private int oppStr;
	private int oppAgi;
	private int oppVit;


	private boolean boxerEffect, opponentEffect;

	StreetMap( CustomMouseListener mouselistener){

		boxerEffect = false;
		opponentEffect = false;

		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		URL mapURL = getClass().getClassLoader().getResource("arena.jpg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		arenaImage = mapIcon.getImage();
		
		mouseListener = mouselistener;
		
		attackTime = 3;

		mapURL = getClass().getClassLoader().getResource("boxer.png");
		mapIcon = new ImageIcon(mapURL);
		boxer = mapIcon.getImage();

		mapURL = getClass().getClassLoader().getResource("opponent.png");
		mapIcon = new ImageIcon(mapURL);
		opponent = mapIcon.getImage();
		
		mapURL = getClass().getClassLoader().getResource("bam.png");
		mapIcon = new ImageIcon( mapURL);
		bam = mapIcon.getImage();



		fightLabel = new JLabel( "Your opponent is ready. What about you?");

		health = 100;
		String healthStr = "Health: " + health;
		healthLabel = new JLabel(healthStr);
		healthLabel.setBounds(0,0,250,50);
		healthLabel.setBorder(border);
		healthLabel.setBackground( Color.GRAY);
		healthLabel.setOpaque(true);
		
		oppStr = 5;
		oppAgi = 5;
		oppVit = 5;
		oppHealth = 100;
		healthStr = "Health: " + oppHealth;
		oppHealthLabel = new JLabel(healthStr);
		oppHealthLabel.setBounds(550,0,250,50);
		oppHealthLabel.setBorder(border);
		oppHealthLabel.setBackground( Color.GRAY);
		oppHealthLabel.setOpaque(true);

		add(healthLabel);
		add(oppHealthLabel);

		skill1 = new JButton("Blow");
		skill2 = new JButton("Fist");
		skill3 = new JButton("Uppercut");
		dodge = new JButton("Dodge");
		

		skill1.setBounds( 50, 475, 100, 50);
		skill2.setBounds( 150, 475, 100, 50);
		skill3.setBounds( 250, 475, 100, 50);
		dodge.setBounds( 350, 475, 100, 50);
		fightLabel.setBounds( 500, 475, 300, 50);
		fightLabel.setBackground( new Color(119, 135, 119));
		fightLabel.setOpaque(true);

		skill1.addMouseListener(mouseListener);
		skill2.addMouseListener(mouseListener);
		skill3.addMouseListener(mouseListener);
		dodge.addMouseListener(mouseListener);
		
		add(skill1);
		add(skill2);
		add(skill3);
		add(dodge);
		add(fightLabel);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(arenaImage, 0,0,800,600,null);
		g.drawImage(boxer, 75,150,200,350,null);
		setOpaque(false);
		g.drawImage(opponent, 575,150,200,350,null);
		if( opponentEffect)
			g.drawImage( bam, 550, 180, 100, 100, null);
		else if( boxerEffect)
			g.drawImage( bam, 180, 180, 100, 100, null);
		
		
	}
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
	public void setHealth( int value){
		health = value;
		String temp = "Health: " + health;
		healthLabel.setText(temp);
	}
	public int getHealth(){
		return health;
	}
	public void updateHealth( int value){
		health = health - value;
		String temp = "Health: " + health;
		healthLabel.setText(temp);
	}
	public void updateOpponentHealth( int value){
		oppHealth = oppHealth - value;
		String temp = "Health: " + oppHealth;
		oppHealthLabel.setText(temp);
	}
	public boolean isFinished(){
		if( health <= 1 || oppHealth <= 1)
			return true;
		else 
			return false;
	}
	public boolean isWin(){
		if( health <= 1)
			return false;
		else 
			return true;
	}
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
	public boolean attack(){
		attackTime = attackTime - 1;
		if( attackTime == 0){
			attackTime = 3;
			return false;
		}
		return true;
	}
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
