import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class SettingsMenu extends JPanel implements ActionListener {
	JLabel mousePoint;
	JFrame window;
	CardLayout cardLayout;

	JButton back;
	JButton apply;
	JTextField red;
	JTextArea redText;

	JTextField green;
	JTextArea greenText;

	JTextField blue;
	JTextArea blueText;

	JSlider soundLevel;

	CustomMouseListener mouse;
	JPanel mainPanel;
	public SettingsMenu( JPanel panel, CardLayout cl){
		mainPanel = panel;
		cardLayout = cl;
		setLayout(null);

		redText = new JTextArea("Red");
		redText.setBounds(150,250,50,25);
		redText.setBackground(Color.lightGray);
		add(redText);
		red = new JTextField(3);
		red.addActionListener(this);
		red.setBounds(150,275,100,25);
		add(red);

		greenText = new JTextArea("Green");
		greenText.setBounds(300,250,50,25);
		greenText.setBackground(Color.lightGray);
		add(greenText);
		green = new JTextField(3);
		green.addActionListener(this);
		green.setBounds(300,275,100,25);
		add(green);

		blueText = new JTextArea("Blue");
		blueText.setBounds(450,250,50,25);
		blueText.setBackground(Color.lightGray);
		add(blueText);
		blue = new JTextField(3);
		blue.addActionListener(this);
		blue.setBounds(450,275,100,25);
		add(blue);

		soundLevel = new JSlider(0,100,50);
		soundLevel.setBounds(250,125,300,25);
		add(soundLevel);


		apply = new JButton("Apply");
		apply.setBounds(580,325,100,35);
		apply.addMouseListener( new CustomMouseListener());
		add(apply);


		back = new JButton("Back");
		back.setBounds(580,425,100,35);
		back.addMouseListener( new CustomMouseListener());
		add(back);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == red){
			System.out.print(e.getActionCommand());
		}
		else if (e.getSource() == red){

		}
		else {

		}


	}

	class CustomMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				cardLayout.show(mainPanel,"main");
			}

		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	}
}
