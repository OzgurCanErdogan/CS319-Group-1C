import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SettingsMenu extends JPanel {
	JLabel mousePoint;
	JFrame window;

	JButton back;
	JButton apply;
	JTextField red;
	JTextArea redText;

	JTextField green;
	JTextArea greenText;

	JTextField blue;
	JTextArea blueText;

	JSlider soundLevel;

	CustomMouseListener2 mouse;

	public SettingsMenu( CustomMouseListener2 mouseListener){
		setLayout(null);
		mouse = mouseListener;

		redText = new JTextArea("Red");
		redText.setBounds(150,250,50,25);
		redText.setBackground(Color.lightGray);
		add(redText);
		red = new JTextField(3);
		red.setBounds(150,275,100,25);
		add(red);

		greenText = new JTextArea("Green");
		greenText.setBounds(300,250,50,25);
		greenText.setBackground(Color.lightGray);
		add(greenText);
		green = new JTextField(3);
		green.setBounds(300,275,100,25);
		add(green);

		blueText = new JTextArea("Blue");
		blueText.setBounds(450,250,50,25);
		blueText.setBackground(Color.lightGray);
		add(blueText);
		blue = new JTextField(3);
		blue.setBounds(450,275,100,25);
		add(blue);

		soundLevel = new JSlider(0,100,50);
		soundLevel.setBounds(250,125,300,25);
		add(soundLevel);


		apply = new JButton("Apply");
		apply.setBounds(580,325,100,35);
		apply.addMouseListener( mouse);
		add(apply);


		back = new JButton("Back");
		back.setBounds(580,425,100,35);
		back.addMouseListener( mouse);
		add(back);

	}
	public JButton getBackButton(){
		return back;
	}
	public JButton getApplyButton(){
		return apply;
	}
	public int getVolume(){
		return (int)soundLevel.getValue();
	}
	public Color getColor(){
		int r = Integer.parseInt(red.getText());
		int g = Integer.parseInt(green.getText());
		int b = Integer.parseInt(blue.getText());
		return new Color( r, g, b);
	}
}
