import java.lang.String;

public class ObjectManager{
	Boxer boxer;
	Item item;
	Skill[] skills;
	Item[] itemlist;
	ObjectManager(){
		skills = new Skill[8];
		itemlist = new Item[11];

	}
	public void createItemList(){
		Item knife = new Item("Knife", 4, 2, 1, 100);
		Item stick = new Item("Stick", 3, 2, 2, 75);
		Item red_gloves = new Item("Red gloves", 2, 1, 3, 80);
    Item blue_gloves = new Item("Blue gloves", 1, 4, 1, 80);
    Item green_gloves = new Item("Green gloves", 5, 0, 1, 80);
    Item glorious_gloves = new Item("Glorious gloves", 5, 4, 3, 370);
    Item bandage_1 = new Item("Standard bandage", 1, 1, 1, 20);
    Item bandage_2 = new Item("High Quality bandage", 3, 3, 3, 120);
    Item headgear = new Item("Normal headgear", 1, 1, 2, 60);
    Item helmet = new Item("Rocky's headgear", 1, 0, 4, 110);
    Item knuckle = new Item("Knuckle", 3, 1, 1, 50);

		itemlist[0] = knife;
		itemlist[1] = stick;
		itemlist[2] = red_gloves;
		itemlist[3] = blue_gloves;
		itemlist[4] = green_gloves;
		itemlist[5] = glorious_gloves;
		itemlist[6] = bandage_1;
		itemlist[7] = bandage_2;
		itemlist[8] = headgear;
		itemlist[9] = helmet;
		itemlist[10] = knuckle;

	}
	public void createSkillSet(){

		Skill jab = new Skill("Jab", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(),0.3,15,20,0);
		skills[0] = jab;
		Skill straight = new Skill("Straight", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.4, 20, 20, 0 );
		skills[1] = straight;
		Skill bolo = new Skill("Bolo",getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.3, 15,10,0);
		skills[2] = bolo;
		Skill uppercut = new Skill("Uppercut", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 1.0, 35, 60, 1050);
		skills[3] = uppercut;
		Skill haymaker = new Skill("Haymaker", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(),0.6 , 25, 35, 450);
		skills[4] = haymaker;
		Skill elbow = new Skill("Elbow Strike", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.4, 20, 25, 450 );
		skills[5] = elbow;
		Skill hook = new Skill("Hook", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.7, 30, 40,750);
		skills[6] = hook;
		Skill cross = new Skill("Cross", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.6, 20, 25, 750);
		skills[7] = cross;

	}
	public void createBoxer( String type){
		boxer = new Boxer(type);
	}
	public int getBoxerHealth(){
		return boxer.getHealth();
	}
	public int getBoxerStrength(){
		return boxer.getStrength();
	}
	public int getBoxerAgility(){
		return boxer.getAgility();
	}
	public int getBoxerVitality(){
		return boxer.getVitality();
	}
	public int getBoxerExperience(){
		return boxer.getExperience();
	}
	public void setBoxerHealth( int newValue){
		boxer.setHealth(newValue);
	}
	public void setBoxerStrength( int newValue){
		boxer.setStrength( newValue);

		for (int i = 0; i<skills.length; i++){
			skills[i].setStr(newValue);
			skills[i].updateDamage();
		}

	}
	public void setBoxerAgility( int newValue){
		boxer.setAgility( newValue);

		for (int i = 0; i<skills.length; i++){
			skills[i].setAgi(newValue);
			skills[i].updateDamage();
		}

	}
	public void setBoxerVitality( int newValue){
		boxer.setVitality( newValue);

		for (int i = 0; i<skills.length; i++){
			skills[i].setVit(newValue);
			skills[i].updateDamage();
		}

	}
	public void setBoxerExperience( int newValue){
		boxer.setExperience( newValue);
	}
	public int getItemNumber(){
		return boxer.getItemNumber();
	}
	public void addItemToInventory( String itemName){
		item = findItem( itemName);
		if( item != null)
			boxer.addItem( item);
	}
	public void removeItemFromInventory( String itemName){
		boxer.removeItem( itemName);
	}
	public int getItemEffect(){
		return boxer.getItemEffect();
	}
	public int getMoney(){
		return boxer.getMoney();
	}
	public void setMoney( int value){
		boxer.setMoney( value);
	}
	public boolean notInInventory( Item item){
		return boxer.notInInventory( item);
	}
	public Item[] getBoxerItems(){
		return boxer.getItems();
	}
	public Item[] getItemlist(){
		return itemlist;
	}
	public Item findItem( String itemName){
		for( int i = 0; i < itemlist.length; i++){
			if( itemlist[i].getName().equals( itemName)){
				return itemlist[i];
			}
		}
		return null;
	}

}
