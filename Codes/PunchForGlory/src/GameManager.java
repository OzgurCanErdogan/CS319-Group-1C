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
	private int looseTime;
	private int mode;
	private int volume;
	private String target;
	// random creater value
	Random rand;

	// initialization of objects
	CustomMouseListener mouseListener;
	MapManager mapManager;
	ObjectManager objectManager;
	Skill[] skillSet = new Skill[3];

	private Color color;

	GameManager(){
		winTime = 0;
		looseTime = 0;
		// create object manager and boxer object
		objectManager = new ObjectManager();
		objectManager.createBoxer( "Butterfly");
		objectManager.createSkillSet();
		objectManager.createItemList();


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

		mapManager.setStreetSkill1Button(objectManager.skills[0].getName());
		setStoreItems();
		setStoreSkills();
		// add mapManager object to panel
		add(mapManager);
	}
	// set and get methods of properties. New values are sent to mapManager class
	public void setSkillNames(){
		mapManager.setStreetSkill1Button(skillSet[0].getName());
		mapManager.setStreetSkill2Button(skillSet[1].getName());
		mapManager.setStreetSkill3Button(skillSet[2].getName());

	}
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
	public JButton getSkillBackButton(){
		return mapManager.skill.getBackButton();
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
	public JButton getSetButton(){
		return mapManager.getSetButton();
	}
	public JButton getStoreBackButton(){
		return mapManager.getStoreBackButton();
	}
	public JButton getRemoveButton(){
		return mapManager.getRemoveButton();
	}
	public JButton getSkillPageContinueButton(){
		return mapManager.getSkillPageContinueButton();
	}
	// calculate the attack power and new health values and send this information to mapManager class
	public void arenaAttackSkill1(){
		int attack = skillSet[0].getTotalDamage();
		//int attack = str * 1;
		mapManager.updateArenaOpponentHealth(attack);
		if( mapManager.arenaAttack() == false){
			int totAttack = 0;
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOpponentAttackEffect();
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			String text = "Your opponent gave you " + totAttack + " damage.";
			mapManager.setArenaFightLabel( text);
		}
		else{
			String text = "You gave " + attack + " damage to your opponent.";
			mapManager.setArenaFightLabel(text);
			mapManager.arenaBoxerAttackEffect();
		}
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin()){
				winTime = winTime + 1;
				setExp( exp + 200);
			}
			else{
				setExp(exp + 100);
				looseTime = looseTime + 1;
				if( mode == 0 && looseTime == 2)
					gameOver();
				else if( mode == 1){
					gameOver();
				}
			}
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
		if( winTime == 3){
			System.exit(0);
		}
	}
	public void arenaAttackSkill2(){
		int attack = skillSet[1].getTotalDamage();
		mapManager.updateArenaOpponentHealth(attack);
		if( mapManager.arenaAttack() == false){
			int totAttack = 0;
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOpponentAttackEffect();
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			String text = "Your opponent gave you " + totAttack + " damage.";
			mapManager.setArenaFightLabel( text);
		}
		else{
			String text = "You gave " + attack + " damage to your opponent.";
			mapManager.setArenaFightLabel(text);
			mapManager.arenaBoxerAttackEffect();
		}
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin()){
				winTime = winTime + 1;
				setExp( exp + 200);
			}
			else{
				setExp(exp + 100);
				looseTime = looseTime + 1;
				if( mode == 0 && looseTime == 2)
					gameOver();
				else if( mode == 1){
					gameOver();
				}
			}
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
		if( winTime == 3){
			System.exit(0);
		}
	}
	public void arenaAttackSkill3(){
		int attack = skillSet[2].getTotalDamage();
		mapManager.updateArenaOpponentHealth(attack);
		if( mapManager.arenaAttack() == false){
			int totAttack = 0;
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			mapManager.arenaOpponentAttackEffect();
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
			String text = "Your opponent gave you " + totAttack + " damage.";
			mapManager.setArenaFightLabel( text);
		}
		else{
			String text = "You gave " + attack + " damage to your opponent.";
			mapManager.setArenaFightLabel(text);
			mapManager.arenaBoxerAttackEffect();
		}
		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin()){
				winTime = winTime + 1;
				setExp( exp + 200);
			}
			else{
				setExp(exp + 100);
				looseTime = looseTime + 1;
				if( mode == 0 && looseTime == 2)
					gameOver();
				else if( mode == 1){
					gameOver();
				}
			}
			changePlace("map");
			setTime(time + 4);
			updateClosedPlaces();
		}
		if( winTime == 3){
			System.exit(0);
		}
	}
	public void arenaDodge(){

		int totAttack = 0;
		totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
		mapManager.arenaOpponentAttackEffect();
		totAttack = totAttack + mapManager.arenaOppAttack( rand.nextInt(3));
		String text = "Your opponent gave you " + totAttack + " damage.";
		mapManager.setArenaFightLabel( text);

		if( mapManager.isArenaFinished()){
			health = mapManager.getArenaHealth();
			setHealth( health);
			if( mapManager.isArenaWin())
				setExp( exp + 200);
			else{
				setExp(exp + 100);
				looseTime = looseTime + 1;
				if( mode == 0 && looseTime == 2)
					gameOver();
				else if( mode == 1){
					gameOver();
				}
			}
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
			int totAttack = 0;
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOpponentAttackEffect();
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			String text = "Your opponent gave you " + totAttack + " damage.";
			mapManager.setStreetFightLabel( text);
		}
		else{
			String text = "You gave " + attack + " damage to your opponent.";
			mapManager.setStreetFightLabel(text);
			mapManager.streetBoxerAttackEffect();
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
			int totAttack = 0;
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOpponentAttackEffect();
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			String text = "Your opponent gave you " + totAttack + " damage.";
			mapManager.setStreetFightLabel( text);
		}else{
			String text = "You gave " + attack + " damage to your opponent.";
			mapManager.setStreetFightLabel(text);
			mapManager.streetBoxerAttackEffect();
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
			int totAttack = 0;
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			mapManager.streetOpponentAttackEffect();
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
			String text = "Your opponent gave you " + totAttack + " damage.";
			mapManager.setStreetFightLabel( text);
		}else{
			String text = "You gave " + attack + " damage to your opponent.";
			mapManager.setStreetFightLabel(text);
			mapManager.streetBoxerAttackEffect();
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

		int totAttack = 0;
		totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
		mapManager.streetOpponentAttackEffect();
		totAttack = totAttack + mapManager.streetOppAttack( rand.nextInt(3));
		String text = "Your opponent gave you " + totAttack + " damage.";
		mapManager.setStreetFightLabel( text);

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
	public void setItem(){

		Skill skill1 = mapManager.getSkill1();
		Skill skill2 = mapManager.getSkill2();
		Skill skill3 = mapManager.getSkill3();

		if (skill1.getExp() <= exp)
			skillSet[0] = skill1;
		if (skill1.getExp() <= exp)
			skillSet[1] = skill2;
		if (skill1.getExp() <= exp)
			skillSet[2] = skill3;

		setSkillNames();


	}
	public void addBoxerItem( Item item){
		mapManager.addBoxerItem( item);
	}
	public void removeItem(){
		if( objectManager.getItemNumber() > 0){
			Item item = mapManager.getRemoveItem();
			objectManager.removeItemFromInventory( item.getName());
			removeBoxerItem();
			int newMoney = objectManager.getMoney();
			newMoney = newMoney + item.getMoney() / 2;
			mapManager.printMoney( newMoney);
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
	public void setStoreItems(){
		Item[] itemlist;
		itemlist = objectManager.getItemlist();
		mapManager.setStoreItems(itemlist);
	}
	public void  setStoreSkills(){
		Skill[] skillList;
		skillList = objectManager.skills;
		mapManager.setStoreSkills(skillList);
	}
	public void setMode( int m){
		mode = m;
	}
	public void setVolume( int level){
		volume = level;
	}
	public void setColor( Color col){
		color = col;
	}
	public void gameOver(){
		System.exit(0);
	}
	public void setTarget( String str){
		target = str;
	}
	public String getTarget(){
		return target;
	}
}
