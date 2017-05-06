import java.lang.String;

public class Boxer{
	private int str, agi, vit, exp, health, money;
	private Inventory inventory;
	Boxer(String type){
		if( type.equals("Tank")){
			str = 5;
			agi = 3;
			vit = 8;
		}else if( type.equals("Butterfly")){
			str = 4;
			agi = 9;
			vit = 3;
		}else if( type.equals("Hammer")){
			str = 8;
			agi = 3;
			vit = 5;
		}else{
			str = 5;
			agi = 5;
			vit = 6;
		}
		exp = 150;
		health = 100;
		inventory = new Inventory();
		money = 550;
	}
	public int getHealth(){
		return health;
	}
	public int getStrength(){
		return str;
	}
	public int getAgility(){
		return agi;
	}
	public int getVitality(){
		return vit;
	}
	public int getExperience(){
		return exp;
	}
	public void setHealth( int newValue){
		health = newValue;
	}
	public void setStrength( int newValue){
		str = newValue;;
	}
	public void setAgility( int newValue){
		agi = newValue;;
	}
	public void setVitality( int newValue){
		vit = newValue;;
	}
	public void setExperience( int newValue){
		exp = newValue;;
	}
	public void addItem( Item item){
		inventory.add( item);
	}
	public int getItemEffect(){
		int additionalAttack = 0;
		int itemNumber = inventory.getItemNumber();
		for( int i = 0; i < itemNumber; i++){
			additionalAttack = additionalAttack + inventory.getItem( i).getEffect();
		}
		return additionalAttack;
	}
	public void setMoney( int value){
		money = value;
	}
	public int getMoney(){
		return money;
	}
	public boolean notInInventory( Item item){
		if( inventory.find( item))
			return false;
		else
			return true;
	}
	public int getItemNumber(){
		return inventory.getItemNumber();
	}
	public Item[] getItems(){
		int itemNumber = inventory.getItemNumber();
		Item[] items = new Item[ itemNumber];
		for ( int i = 0; i < itemNumber; i++){
			items[i] = inventory.getItem(i);
		}
		return items;
	}
	public void removeItem( String itemName){
		inventory.remove( itemName);
	}

	public class Inventory{
		Item[] itemList;
		int itemNumber;
		Inventory(){
			itemNumber = 0;
			itemList = new Item[3];
			for( int i =0; i < 3; i++){
				itemList[i] = null;
			}
		}
		public void add( Item item){
			itemList[itemNumber] = item;
			itemNumber = itemNumber + 1;
		}
		public int getItemNumber(){
			return itemNumber;
		}
		public Item getItem( int index){
			return itemList[index];
		}
		public boolean find( Item item){
			for( int i = 0; i < itemNumber; i++){
				if( itemList[i].getName().equals( item.getName()))
					return true;
			}
			return false;
		}
		public void remove( String itemName){
			for( int i = 0; i < itemNumber; i++){
				if( itemList[i].getName().equals( itemName)){
					for( int k = i + 1; k < itemNumber; k++){
						itemList[k-1] = itemList[k];
					}
					itemNumber = itemNumber - 1;
				}
					
			}
		}
	}
}
