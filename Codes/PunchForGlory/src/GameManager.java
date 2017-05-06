import java.awt.*;  
import javax.swing.*;  
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.Random;

public class GameManager extends JPanel{	
	// screen properties
	public static final int height = 600;
	public static final int width = 800;
	
	//character properties
	private int health;
	private int str;
	private int agi;
	private int vit;
	private int exp;
	private int time;
	
	private int winTime;
	// random creater value
	Random rand;
		
	// initialization of objects
	CustomMouseListener mouseListener;	
	MapManager mapManager;
	ObjectManager objectManager;

	GameManager(){
		winTime = 0;
		// create object manager and boxer object		
		objectManager = new ObjectManager();
		objectManager.createBoxer( "Butterfly");

		//assignment of character properties
		health = objectManager.getBoxerHealth();
		str = objectManager.getBoxerStrength();
		agi = objectManager.getBoxerAgility();
		vit = objectManager.getBoxerVitality();
		exp = objectManager.getBoxerExperience();
		time = 12;

		// assignment of objects
		rand = new Random();
		mouseListener = new CustomMouseListener( this);
		mapManager = new MapManager(mouseListener);
		mapManager.setPreferredSize(new Dimension(width,height));
		
		// method calls to set property labels of boxer
		setHealth(health);
		setStr(str);
		setAgi(agi);
		setVit(vit);
		setExp(exp);
		setTime(time);
		
		// add mapManager object to panel
		add(mapManager);
	}
	// set and get methods of properties. New values are sent to mapManager class
	public void setHealth( int newHealth){
		health = newHealth;
		if( health > 100)
			health = 100;
		if( health < 1)
			health = 1;
		objectManager.setBoxerHealth(health);
		mapManager.updateHealth( health);
	}
	public int getHealth(){
		return objectManager.getBoxerHealth();
	}
	public void setStr( int newStr){
		objectManager.setBoxerStrength( newStr);
		str = newStr;
		mapManager.updateStr( str);
	}
	public int getStr(){
		return objectManager.getBoxerStrength();
	}
	public void setAgi( int newAgi){
		objectManager.setBoxerAgility( newAgi);
		agi = newAgi;
		mapManager.updateAgi( agi);
	}
	public int getAgi(){
		return objectManager.getBoxerAgility();
	}
	public void setVit( int newVit){
		objectManager.setBoxerVitality( newVit);
		vit = newVit;
		mapManager.updateVit( vit);
	}
	public int getVit(){
		return objectManager.getBoxerVitality();
	}
	public void setExp( int newExp){
		objectManager.setBoxerExperience( newExp);
		exp = newExp;
		mapManager.updateExp( exp);
	}
	public int getExp(){
		return objectManager.getBoxerExperience();
	}
	public void setTime( int newTime){
		time = newTime;
		if( time > 24)
			time = time - 24;
		mapManager.updateTime( time);
	}
	public int getTime(){
		return time;
	}
	// method call of card layout for displaying other places
	public void changePlace( String place){
		mapManager.change( place);
	}
	// reset of arena and street to create a new opponent
	public void resetArena(){
		mapManager.resetArena( str, agi, vit);
		mapManager.setArenaHealth( health);
	}
	public void resetStreet(){
		mapManager.resetStreet( str, agi, vit);
		mapManager.setStreetHealth( health);
	}
	// getting button objects from mapManager class
	public JButton getGymBackButton(){
		return mapManager.getGymBackButton();
	}
	public JButton getGymDoIt1Button(){
		return mapManager.getGymDoIt1Button();
	}
	public JButton getGymDoIt2Button(){
		return mapManager.getGymDoIt2Button();
	}
	public JButton getGymDoIt3Button(){
		return mapManager.getGymDoIt3Button();
	}
	public JButton getHomeBackButton(){
		return mapManager.getHomeBackButton();
	}
	public JButton getHomeSleepButton(){
		return mapManager.getHomeSleepButton();
	}
	public JButton getWorkBackButton(){
		return mapManager.getWorkBackButton();
	}
	public JButton getWorkButton(){
		return mapManager.getWorkButton();
	}
	public JButton getArenaSkill1Button(){
		return mapManager.getArenaSkill1Button();
	}
	public JButton getArenaSkill2Button(){
		return mapManager.getArenaSkill2Button();
	}
	public JButton getArenaSkill3Button(){
		return mapManager.getArenaSkill3Button();
	}
	public JButton getArenaDodgeButton(){
		return mapManager.getArenaDodgeButton();
	}
	public JButton getStreetSkill1Button(){
		return mapManager.getStreetSkill1Button();
	}
	public JButton getStreetSkill2Button(){
		return mapManager.getStreetSkill2Button();
	}
	public JButton getStreetSkill3Button(){
		return mapManager.getStreetSkill3Button();
	}
	public JButton getStreetDodgeButton(){
		return mapManager.getStreetDodgeButton();
	}
	public JButton getBuyButton(){
		return mapManager.getBuyButton();
	}
	public JButton getStoreBackButton(){
		return mapManager.getStoreBackButton();
	}
	public JButton getRemoveButton(){
		return mapManager.getRemoveButton();
	}
	// calculate the attack power and new health values and send this information to mapManager class
	public void arenaAttackSkill1(){
		int attack = str * 1;
		mapManager.updateArenaOpponentHealth(attack);
		if( mapManager.arenaAttack() == false){
			mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOppAttack( rand.nextInt(3));
		}
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin()){
				winTime = winTime + 1;
				setExp( exp + 200);
			}
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
		if( winTime == 3){
			System.exit(0);
		}
	}
	public void arenaAttackSkill2(){
		int attack = str * 2 + agi * 1;
		mapManager.updateArenaOpponentHealth(attack);
		if( mapManager.arenaAttack() == false){
			mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOppAttack( rand.nextInt(3));
		}
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin()){
				winTime = winTime + 1;
				setExp( exp + 200);
			}
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
		if( winTime == 3){
			System.exit(0);
		}
	}
	public void arenaAttackSkill3(){
		int attack = str * 3 + agi * 2;
		mapManager.updateArenaOpponentHealth(attack);
		if( mapManager.arenaAttack() == false){
			mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOppAttack( rand.nextInt(3));
		}
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin()){
				winTime = winTime + 1;
				setExp( exp + 200);
			}
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
		if( winTime == 3){
			System.exit(0);
		}
	}
	public void arenaDodge(){
		
		mapManager.arenaOppAttack( rand.nextInt(3));
		mapManager.arenaOppAttack( rand.nextInt(3));
		
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin())
				setExp( exp + 200);
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
	}
	public void streetAttackSkill1(){
		int attack = str * 1;
		attack = attack + objectManager.getItemEffect();
		mapManager.updateStreetOpponentHealth(attack);
		if( mapManager.streetAttack() == false){
			mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOppAttack( rand.nextInt(3));
		}
		if( mapManager.isStreetFinished()){
			health = mapManager.getStreetHealth();
			setHealth( health);
			if( mapManager.isStreetWin())
				setExp( exp + 200);
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
	}
	public void streetAttackSkill2(){
		int attack = str * 2 + agi * 1;
		attack = attack + objectManager.getItemEffect();
		mapManager.updateStreetOpponentHealth(attack);
		if( mapManager.streetAttack() == false){
			mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOppAttack( rand.nextInt(3));
		}
		if( mapManager.isStreetFinished()){
			health = mapManager.getStreetHealth();
			setHealth( health);
			if( mapManager.isStreetWin())
				setExp( exp + 200);
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
	}
	public void streetAttackSkill3(){
		int attack = str * 3 + agi * 2;
		attack = attack + objectManager.getItemEffect();
		mapManager.updateStreetOpponentHealth(attack);
		if( mapManager.streetAttack() == false){
			mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOppAttack( rand.nextInt(3));
		}
		if( mapManager.isStreetFinished()){
			health = mapManager.getStreetHealth();
			setHealth( health);
			if( mapManager.isStreetWin())
				setExp( exp + 200);
			else
				setExp(exp + 100);
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
	}
	public void streetDodge(){
		
		mapManager.streetOppAttack( rand.nextInt(3));
		mapManager.streetOppAttack( rand.nextInt(3));
		
		if( mapManager.isStreetFinished()){
			health = mapManager.getStreetHealth();
			setHealth( health);
			if( mapManager.isStreetWin())
				setExp( exp + 200);
			else
				setExp(exp + 100);	
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
	}
	public int getMoney(){
		return objectManager.getMoney();
	}
	public void setMoney( int value){
		objectManager.setMoney(value);
	}
	public void printMoney(){
		int money = objectManager.getMoney();
		mapManager.printMoney( money);
	}
	public void buyItem(){
		if( objectManager.getItemNumber() < 3){
			Item item = mapManager.getBuyItem();
			int money = item.getMoney();
			if( getMoney() >= money && objectManager.notInInventory( item)){
				setMoney( getMoney() - money);
				printMoney();
				objectManager.addItemToInventory( item.getName());
				addBoxerItem( item);
			}
		}
	}
	public void addBoxerItem( Item item){
		mapManager.addBoxerItem( item);
	}
	public void removeItem(){
		if( objectManager.getItemNumber() > 0){
			Item item = mapManager.getRemoveItem();
			objectManager.removeItemFromInventory( item.getName());
			removeBoxerItem();
		}
	}
	public void removeBoxerItem(){
		mapManager.removeBoxerItem();
	}
	public boolean isOpen(){
		if( time < 22 && time > 6)
			return true;
		else{ 
			return false;
		}
	}
	public void updateClosedPlaces(){
		if( !isOpen())
			mapManager.updateClosedPlaces();
		else
			mapManager.updateOpenPlaces();
	}
}