import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.Random;

public class MapManager extends JPanel{
	public static final int height = 600;
	public static final int width = 800;
	private JFrame window;
	private CardLayout cardLayout;
	private JPanel mainPanel;


	private JLabel strLabel;
	private JLabel agiLabel;
	private JLabel vitLabel;
	private JLabel expLabel;
	private JLabel timeLabel;
	private JLabel healthLabel;

	IntroPanel intro;
	Map map;
	GymMap gym;
	HomeMap home;
	WorkMap work;
	ArenaMap arena;
	StreetMap street;
	StoreMap store;
	CustomMouseListener mouseListener;
	Random rand;
	SkillMap skill;
	BossFight bossFight;
	WinPanel winPanel;
	LosePanel losePanel;

	public MapManager( CustomMouseListener mouselistener){

		setLayout( new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(width, height- 50));
		add(mainPanel, BorderLayout.CENTER);
		mouseListener = mouselistener;

		rand = new Random();

		// boxer properties
		JPanel properties = new JPanel();
		FlowLayout flow = new FlowLayout(5);
		properties.setLayout( flow);
		properties.setPreferredSize(new Dimension( width, 50));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);

		//print health value on the screen
		healthLabel = new JLabel();
		healthLabel.setPreferredSize( new Dimension( 120, 40));
		healthLabel.setBorder(border);

		// print strength value on the screen
		strLabel = new JLabel();
		strLabel.setPreferredSize( new Dimension( 120, 40));
		strLabel.setBorder(border);

		// print agility value on the screen
		agiLabel = new JLabel();
		agiLabel.setPreferredSize( new Dimension( 120, 40));
		agiLabel.setBorder(border);

		// print vitality value on the screen
		vitLabel = new JLabel();
		vitLabel.setPreferredSize( new Dimension( 120, 40));
		vitLabel.setBorder(border);

		// print experience value on the screen
		expLabel = new JLabel();
		expLabel.setPreferredSize( new Dimension( 150, 40));
		expLabel.setBorder(border);

		// print time value on the screen
		timeLabel = new JLabel();
		timeLabel.setPreferredSize( new Dimension( 120, 40));
		timeLabel.setBorder(border);


		// adding character property labels on properties panel
		properties.add(healthLabel);
		properties.add(strLabel);
		properties.add(agiLabel);
		properties.add(vitLabel);
		properties.add(expLabel);
		properties.add(timeLabel);

		// put properties panel on main panel
		add(properties, BorderLayout.NORTH);

		// MainPanel layout creation
		cardLayout = new CardLayout();
		mainPanel.setLayout( cardLayout);

		// Game IntroPanel
		intro = new IntroPanel( mouseListener);
		mainPanel.add("intro", intro);

		// general map adding
		map = new Map( mouseListener);
		//map.setPreferredSize( new Dimension(width, height - 100));
		map.addMouseListener( mouseListener);
		mainPanel.add("map",map);

		//adding home map
		home = new HomeMap( mouseListener);
		mainPanel.add("home",home);

		//adding work map
		work = new WorkMap( mouseListener);
		mainPanel.add("work",work);

		//adding gym map
		gym = new GymMap( mouseListener);
		mainPanel.add("gym",gym);

		// adding arena map
		arena = new ArenaMap( mouseListener);
		mainPanel.add("arena",arena);

		// adding street map
		street = new StreetMap( mouseListener);
		mainPanel.add("street", street);

		// adding store map
		store = new StoreMap( mouseListener);
		mainPanel.add("store", store);

		bossFight = new BossFight(mouseListener);
		bossFight.setPreferredSize(new Dimension(width,height));
		mainPanel.add("bossFight", bossFight);

		// adding skill map
		skill = new SkillMap(mouseListener);
		mainPanel.add("skill", skill);

		winPanel = new WinPanel(mouseListener);
		mainPanel.add("winPanel", winPanel);

		losePanel = new LosePanel(mouseListener);
		mainPanel.add("losePanel", losePanel);

	}


	public void updateHealth( int health){
		String healthText = "Health: " + health;
		healthLabel.setText(healthText);
	}
	public void updateStr( int str){
		String strText = "Strength: " + str;
		strLabel.setText(strText);
	}
	public void updateAgi( int agi){
		String agiText = "Agility: " + agi;
		agiLabel.setText(agiText);
	}
	public void updateVit( int vit){
		String vitText = "Vitality: " + vit;
		vitLabel.setText(vitText);
	}
	public void updateExp( int exp){
		String expText = "Experience: " + exp;
		expLabel.setText(expText);
	}
	public void updateTime( int time){
		String timeText = "Time: " + time + ":00";
		timeLabel.setText(timeText);
	}
	public void change( String place){
		cardLayout.show(mainPanel, place);
	}
	public JPanel getMainPanel(){
		return mainPanel;
	}
	public CardLayout getCardLayout(){
		return cardLayout;
	}
	public void resetArena( int str, int agi, int vit){
		arena.reset( str, agi, vit);
	}
	public void setStreetSkill1Button(String newSkill){
		arena.setSkill1Name(newSkill);
	}
	public void setStreetSkill2Button(String newSkill){
		arena.setSkill2Name(newSkill);
	}
	public void setStreetSkill3Button(String newSkill){
		arena.setSkill3Name(newSkill);
	}

	public void setSkill1Button(String newSkill){
		street.setSkill1Name(newSkill);
	}
	public void setSkill2Button(String newSkill){
		street.setSkill2Name(newSkill);
	}
	public void setSkill3Button(String newSkill){
		street.setSkill3Name(newSkill);
	}

	public void setArenaHealth( int health){
		arena.setHealth(health);
	}
	public void resetStreet( int str, int agi, int vit){
		street.reset( str, agi, vit);
	}
	public void setStreetHealth( int health){
		street.setHealth(health);
	}
	public JButton getHomeBackButton(){
		return home.getBackButton();
	}
	public JButton getHomeSleepButton(){
		return home.getSleepButton();
	}
	public JButton getWorkBackButton(){
		return work.getBackButton();
	}
	public JButton getWorkButton(){
		return work.getWorkButton();
	}
	public JButton getGymBackButton(){
		return gym.getBackButton();
	}
	public JButton getGymDoIt1Button(){
		return gym.getDoIt1Button();
	}
	public JButton getGymDoIt2Button(){
		return gym.getDoIt2Button();
	}
	public JButton getGymDoIt3Button(){
		return gym.getDoIt3Button();
	}
	public JButton getSkillBackButton(){
		return skill.getBackButton();
	}
	public JButton getArenaSkill1Button(){
		return arena.getSkill1Button();
	}
	public JButton getArenaSkill2Button(){
		return arena.getSkill2Button();
	}
	public JButton getArenaSkill3Button(){
		return arena.getSkill3Button();
	}
	public JButton getArenaDodgeButton(){
		return arena.getDodgeButton();
	}
	public JButton getStreetSkill1Button(){
		return street.getSkill1Button();
	}
	public JButton getStreetSkill2Button(){
		return street.getSkill2Button();
	}
	public JButton getStreetSkill3Button(){
		return street.getSkill3Button();
	}
	public JButton getStreetDodgeButton(){
		return street.getDodgeButton();
	}
	public JButton getStoreBackButton(){
		return store.getBackButton();
	}
	public JButton getBuyButton(){
		return store.getBuyButton();
	}
	public JButton getSetButton(){
		return skill.getSetButton();
	}
	public JButton getRemoveButton(){
		return store.getRemoveButton();
	}
	public JButton getSkillPageContinueButton(){
		return skill.getContinueButton();
	}
	public JButton getIntroContButton(){
		return intro.getContButton();
	}
	public JButton getBossFightRunButton(){
		return bossFight.getRunButton();
	}
	public JButton getBossFightFightButton(){
		return bossFight.getFightButton();
	}
	public void updateArenaOpponentHealth(int attack){
		arena.updateOpponentHealth( attack);
	}
	public boolean arenaAttack(){
		return arena.attack();
	}
	public int arenaOppAttack( int attack){
		return arena.oppAttack( attack);
	}
	public boolean isArenaFinished( ){
		return arena.isFinished( );
	}
	public int getArenaHealth(){
		return arena.getHealth();
	}
	public boolean isArenaWin(){
		return arena.isWin();
	}
	public void updateStreetOpponentHealth(int attack){
		street.updateOpponentHealth( attack);
	}
	public boolean streetAttack(){
		return street.attack();
	}
	public int streetOppAttack( int attack){
		return street.oppAttack( attack);
	}
	public boolean isStreetFinished(){
		return street.isFinished();
	}
	public int getStreetHealth(){
		return street.getHealth();
	}
	public boolean isStreetWin(){
		return street.isWin();
	}
	public String toString(){
		return "hello this is mapManager";
	}
	public void printMoney( int value){
		store.setMoneyLabel( value);
	}
	public Item getBuyItem(){
		return store.getBuyItem();
	}
	public Skill getSkill1(){
		return skill.getSkill1();
	}
	public Skill getSkill2(){
		return skill.getSkill2();
	}
	public Skill getSkill3(){
		return skill.getSkill3();
	}
	public Item getRemoveItem(){
		return store.getRemoveItem();
	}
	public void addBoxerItem( Item item){
		store.addBoxerItem( item);
	}
	public void removeBoxerItem(){
		store.removeBoxerItem();
	}
	public void updateClosedPlaces(){
		map.updateClosedPlaces();
	}
	public void updateOpenPlaces(){
		map.updateOpenPlaces();
	}
	public void setArenaFightLabel( String text){
		arena.setFightLabel( text);
	}
	public void setStreetFightLabel( String text){
		street.setFightLabel(text);
	}
	public void arenaBoxerAttackEffect(){
		arena.boxerAttackEffect();
	}
	public void arenaOpponentAttackEffect(){
		arena.opponentAttackEffect();
	}
	public void streetBoxerAttackEffect(){
		street.boxerAttackEffect();
	}
	public void streetOpponentAttackEffect(){
		street.opponentAttackEffect();
	}
	public void setStoreItems( Item[] itemlist){
		store.setStoreItems(itemlist);
	}
	public void setStoreSkills(Skill[] skillList){
		skill.setSkillList(skillList);
	}
}
