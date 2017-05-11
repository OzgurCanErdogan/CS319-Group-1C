import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.border.Border;

class CustomMouseListener implements MouseListener{
	// initialize objects
	GameManager game;
	int x, y;
	CustomMouseListener(){}
	CustomMouseListener(GameManager g){
		game = g;
	}
		public void mouseClicked(MouseEvent e){

			x = e.getX();
			y = e.getY();

			// used methods when mouse is clicked somewhere on map
			if( x < 350 && x > 320 && y < 150 && y > 110){
				game.changePlace( "home");

			}else if( x < 160 && x> 100 && y < 310 && y> 260){
					// work
				if(game.isOpen())
					game.changePlace( "work");

			}else if( x < 330 && x> 280 && y < 310 && y > 260 ){
				// arena
				game.changePlace("skill");
				game.setTarget("arena");
			}else if( x < 580 && x > 530 && y < 305 && y > 245){
				// gym
				if( game.isOpen())
					game.changePlace( "gym");
			}else if( x < 660 && x > 605 && y < 110 && y > 55 ){
				// street
				game.changePlace("skill");
				game.setTarget("street");
			}else if( x < 800 && x > 750 && y < 305 && y > 245){
				// store
				if( game.isOpen()){
					game.printMoney();
					game.changePlace( "store");

				}
			// used methods when mouse is clicked on a button
			// gym buttons
			} else if(e.getSource() == game.getSkillBackButton()){
				game.changePlace("map");

			}else if( e.getSource() == game.getGymBackButton()){
				game.updateClosedPlaces();
				game.changePlace( "map");
			}else if(e.getSource() == game.getGymDoIt1Button()){
				game.setStr( game.getStr() + 1);
				game.setTime(game.getTime() + 2);
				if( !game.isOpen()){
					game.updateClosedPlaces();
					game.changePlace("map");
				}
			}else if(e.getSource() == game.getGymDoIt2Button()){
				game.setTime(game.getTime() + 2);
				game.setAgi( game.getAgi() + 1);
				if( !game.isOpen()){
					game.updateClosedPlaces();
					game.changePlace("map");
				}
			}else if(e.getSource() == game.getGymDoIt3Button()){
				game.setVit( game.getVit() + 1);
				game.setTime(game.getTime() + 2);
				if( !game.isOpen()){
					game.updateClosedPlaces();
					game.changePlace("map");
				}
			// home buttons
			}else if( e.getSource() == game.getHomeBackButton()){
				game.updateClosedPlaces();
				game.changePlace( "map");
			}else if(e.getSource() == game.getHomeSleepButton()){
				game.setHealth( game.getHealth() + 50);
				game.setTime(game.getTime() + 8);
				game.updateClosedPlaces();
				game.changePlace( "map");
			// work buttons
			}else if( e.getSource() == game.getWorkBackButton()){
				game.updateClosedPlaces();
				game.changePlace( "map");
			}else if(e.getSource() == game.getWorkButton()){
				game.setMoney( game.getMoney() + 30);
				game.setTime(game.getTime() + 8);
				game.updateClosedPlaces();
				game.changePlace( "map");
			// arena buttons
			}else if(e.getSource() == game.getArenaSkill1Button()){
				game.arenaAttackSkill1();
			}else if(e.getSource() == game.getArenaSkill2Button()){
				game.arenaAttackSkill2();
			}else if(e.getSource() == game.getArenaSkill3Button()){
				game.arenaAttackSkill2();
			}else if(e.getSource() == game.getArenaDodgeButton()){
				game.arenaDodge();
			// street buttons
			}else if(e.getSource() == game.getStreetSkill1Button()){
				game.streetAttackSkill1();
			}else if(e.getSource() == game.getStreetSkill2Button()){
				game.streetAttackSkill2();
			}else if(e.getSource() == game.getStreetSkill3Button()){
				game.streetAttackSkill3();
			}else if(e.getSource() == game.getStreetDodgeButton()){
				game.streetDodge();
			}else if( e.getSource() == game.getBuyButton()){
				game.buyItem();
			}else if(e.getSource() == game.getSetButton()){
				game.setItem();
			}
			else if( e.getSource() == game.getRemoveButton()){
				game.removeItem();
			}else if( e.getSource() == game.getStoreBackButton()){
				game.updateClosedPlaces();
				game.changePlace("map");
			}else if( e.getSource() == game.getSkillPageContinueButton()){
				String target = game.getTarget();
				if( target.equals("arena")){
					game.resetArena();
					game.changePlace("arena");
				}else if( target.equals("street")){
					game.resetStreet();
					game.changePlace( "street");
				}
			}else if( e.getSource() == game.getIntroContButton()){
				game.changePlace("map");
			}else if( e.getSource() == game.getBossFightRunButton()){
				game.changePlace("map");
			}else if( e.getSource() == game.getBossFightFightButton()){
				game.changePlace("arena");
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	}
