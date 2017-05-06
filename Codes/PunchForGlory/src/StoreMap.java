import java.awt.*;
import javax.swing.*;
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

		Item knife = new Item("Knife");
		Item stick = new Item("Stick");	
		Item knuckle = new Item("Knuckle");

		itemList = new JComboBox<Item>();
		itemList.addItem( knife);
		itemList.addItem(stick);
		itemList.addItem(knuckle);
	
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
}
