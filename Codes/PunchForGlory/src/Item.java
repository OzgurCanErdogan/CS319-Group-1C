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
		else if( name.equals("Red gloves")){
			str = 2;
			agi = 1;
			vit = 3;
			money = 80;
		}
		else if( name.equals("Blue gloves")){
			str = 1;
			agi = 4;
			vit = 1;
			money = 80;
		}
		else if( name.equals("Green gloves")){
			str = 5;
			agi = 0;
			vit = 1;
			money = 80;
		}
		else if( name.equals("Glorious gloves")){
			str = 5;
			agi = 4;
			vit = 3;
			money = 370;
		}
		else if( name.equals("Standard bandage")){
			str = 1;
			agi = 1;
			vit = 1;
			money = 20;
		}
		else if( name.equals("High Quality bandage")){
			str = 3;
			agi = 3;
			vit = 3;
			money = 120;
		}
		else if( name.equals("Normal headgear")){
			str = 1;
			agi = 1;
			vit = 2;
			money = 60;
		}
		else if( name.equals("Rocky's headgear")){
			str = 1;
			agi = 0;
			vit = 4;
			money = 110;
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
