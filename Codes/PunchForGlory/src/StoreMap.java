import java.awt.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;

public class StoreMap extends JPanel{
	JButton back;
	JButton buy;
	JLabel moneyLabel;
	JComboBox<Item> itemList, boxerItems;
	JLabel storeLabel;
	JLabel yourItemsLabel;
	JButton remove;

	CustomMouseListener mouseListener;

	StoreMap( CustomMouseListener mouselistener){
		setLayout(null);
		mouseListener = mouselistener;

		moneyLabel = new JLabel( "Your Money: ");
		storeLabel = new JLabel( "Store Items");
		yourItemsLabel = new JLabel( "Your Items");
		back = new JButton("Back");
		buy = new JButton( "Buy");
		remove = new JButton( "Remove");

		back.addMouseListener( mouseListener);
		buy.addMouseListener( mouseListener);
		remove.addMouseListener( mouseListener);

		moneyLabel.setBounds( 100, 50, 300, 50);
		storeLabel.setBounds( 100, 100, 200, 50);
		buy.setBounds( 100, 220, 100, 50);
		yourItemsLabel.setBounds( 100, 280, 300, 50);
		back.setBounds( 100, 460, 100, 50);
		remove.setBounds( 100, 390 , 100, 50);
/*
		Item knife = new Item("Knife");
		Item stick = new Item("Stick");
		Item red_gloves = new Item("Red gloves");
        Item blue_gloves = new Item("Blue gloves");
        Item green_gloves = new Item("Green gloves");
        Item glorious_gloves = new Item("Glorious gloves");
        Item bandage_1 = new Item("Standard bandage");
        Item bandage_2 = new Item("High Quality bandage");
        Item headgear = new Item("Normal headgear");
        Item helmet = new Item("Rocky's headgear");
        Item knuckle = new Item("Knuckle");


		itemList = new JComboBox<Item>();
		itemList.addItem( knife);
		itemList.addItem(stick);
		itemList.addItem(knuckle);
        itemList.addItem(red_gloves);
        itemList.addItem(blue_gloves);
        itemList.addItem(green_gloves);
        itemList.addItem(glorious_gloves);
        itemList.addItem(bandage_1);
        itemList.addItem(bandage_2);
        itemList.addItem(headgear);
        itemList.addItem(helmet);
*/
		itemList = new JComboBox<Item>();
		itemList.setBounds( 100, 150, 400, 50);

		boxerItems = new JComboBox<Item>();
		boxerItems.setBounds( 100, 320, 400, 50);

		add(boxerItems);
		add( remove);
		add(yourItemsLabel);
		add( storeLabel);
		add(buy);
		add( moneyLabel);
		add(back);
		add( itemList);
	}
	public JButton getBuyButton(){
		return buy;
	}
	public JButton getRemoveButton(){
		return remove;
	}
	public void setMoneyLabel( int value){
		moneyLabel.setText("Your Money: " + value + " TL");
	}
	public JButton getBackButton(){
		return back;
	}
	public Item getBuyItem(){
		return (Item)itemList.getSelectedItem();
	}
	public Item getRemoveItem(){
		return (Item)boxerItems.getSelectedItem();
	}
	public void addBoxerItem( Item item){
		boxerItems.addItem( item);
	}
	public void removeBoxerItem(){
		boxerItems.removeItemAt( boxerItems.getSelectedIndex());
	}
	public void setStoreItems( Item[] itemlist){
		for( int i = 0; i< itemlist.length; i++){
			itemList.addItem(itemlist[i]);
		}
	}

}
