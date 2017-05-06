import java.lang.String;

public class ObjectManager{
	Boxer boxer;
	Item item;
	ObjectManager(){}
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
	}
	public void setBoxerAgility( int newValue){
		boxer.setAgility( newValue);
	}
	public void setBoxerVitality( int newValue){
		boxer.setVitality( newValue);
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
