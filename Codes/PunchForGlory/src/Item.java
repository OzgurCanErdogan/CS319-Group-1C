import java.lang.String;

public class Item{
	private int str, agi, vit, money;
	private String name;
	Item( String nameInput){
		name = nameInput;
		if( name.equals("Knife")){
			str = 4;
			agi = 2;
			vit = 1;
			money = 100;
		}else if( name.equals("Stick")){
			str = 3;
			agi = 2;
			vit = 2;
			money = 75;
		}else if( name.equals("Knuckle")){
			str = 3;
			agi = 1;
			vit = 1;
			money = 50;
		}
	}
	public int getEffect(){
		int effect = str * 1 + agi * 1 + vit * 1;
		return effect;
	}	
	public String toString(){
		String temp = name + ": str +" + str + ", agi +" + agi + ", vit +" + vit + ".  Costs: " + money + " TL";
		return temp;
	}
	public int getMoney(){
		return money;
	}	
	public String getName(){
		return name;
	}
}
