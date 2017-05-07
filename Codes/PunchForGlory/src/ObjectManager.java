import java.lang.String;

public class ObjectManager{
	Boxer boxer;
	Item item;
	Skill[] skills = new Skill[8];
	ObjectManager(){


	}
	public void createSkillSet(){

		Skill jab = new Skill("Jab", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(),0.3,15,20,0);
		skills[0] = jab;
		Skill straight = new Skill("The Straight", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.4, 20, 20, 0 );
		skills[1] = straight;
		Skill bolo = new Skill("The Bolo",getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 0.3, 15,10,0);
		skills[2] = bolo;
		Skill uppercut = new Skill("Uppercut", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(), 1.0, 35, 60, 1050);
		skills[3] = uppercut;
		Skill haymaker = new Skill("The Haymaker", getBoxerStrength(),getBoxerAgility(),getBoxerVitality(),0.6 , 25, 35, 450);
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
		item = new Item( itemName);
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


}
