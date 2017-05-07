import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class Map extends JPanel{
	Image mapImage;
	JLabel homeLabel;
	JLabel workLabel;
	JLabel gymLabel;
	JLabel arenaLabel;
	JLabel streetLabel;
	JLabel storeLabel;

	JButton skillButton;
	CustomMouseListener mouseListener;

	public Map( CustomMouseListener ml){
		mouseListener = ml;
		setLayout(null);
		URL mapURL = getClass().getClassLoader().getResource("map.jpeg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		mapImage = mapIcon.getImage();

		homeLabel = new JLabel("Home");
		workLabel = new JLabel("Work <open>");
		gymLabel = new JLabel("Gym <open>");
		arenaLabel = new JLabel("Arena");
		streetLabel = new JLabel("Street Arena");
		storeLabel = new JLabel("Store <open>");
		skillButton = new JButton("Skill Set");

		Color color = new Color(119, 135, 119);

		homeLabel.setBackground(color);
		workLabel.setBackground(color);
		gymLabel.setBackground(color);
		arenaLabel.setBackground(color);
		streetLabel.setBackground(color);
		storeLabel.setBackground(color);
		skillButton.setBackground(color);

		homeLabel.setOpaque(true);
		workLabel.setOpaque(true);
		gymLabel.setOpaque(true);
		arenaLabel.setOpaque(true);
		streetLabel.setOpaque(true);
		storeLabel.setOpaque(true);

		homeLabel.setBounds( 300, 70, 50, 30);
		workLabel.setBounds( 80, 220, 110, 30);
		gymLabel.setBounds( 500, 210, 100, 30);
		arenaLabel.setBounds( 280, 230, 50, 30);
		streetLabel.setBounds( 595, 20, 100, 30);
		storeLabel.setBounds( 690, 210, 110, 30);
		skillButton.setBounds(25,25,100,25);


		skillButton.addMouseListener( mouseListener);

		add(homeLabel);
		add(workLabel);
		add(gymLabel);
		add(arenaLabel);
		add(streetLabel);
		add(storeLabel);
		add(skillButton);

	}
	//@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(mapImage, 0,0,800,550,null);

	}
	public void updateClosedPlaces(){
		workLabel.setText("Work <closed>");
		gymLabel.setText("Gym <closed>");
		storeLabel.setText("Store <closed>");
	}
	public void updateOpenPlaces(){
		workLabel.setText("Work <open>");
		gymLabel.setText("Gym <open>");
		storeLabel.setText("Store <open>");
	}
	public JButton getSkillButton(){
		return skillButton;
	}
}
