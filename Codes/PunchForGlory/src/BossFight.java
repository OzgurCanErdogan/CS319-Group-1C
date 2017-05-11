import java.awt.*;
import javax.swing.*;

public class BossFight extends JPanel{
CustomMouseListener mouseListener;
  JLabel bossFightLabel;
  JButton bossRunButton;
  JButton bossFightButton;
  BossFight( CustomMouseListener mouselistener){
    mouseListener = mouselistener;
		setLayout(null);
    setOpaque(true);
    setBackground(Color.BLACK);
		bossFightLabel = new JLabel("Time for fight with boss again. Are you ready?");
		bossFightButton = new JButton("Fight");
		bossRunButton = new JButton("Run");

    bossFightLabel.setBounds (200, 200, 400, 50);
		bossRunButton.setBounds(250,300,100,50);
		bossFightButton.setBounds(380,300,100,50);

    bossRunButton.addMouseListener( mouseListener);
    bossFightButton.addMouseListener( mouseListener);

		add(bossFightLabel);
		add(bossFightButton);
		add(bossRunButton);
  }
  public JButton getRunButton(){
    return bossRunButton;
  }
  public JButton getFightButton(){
    return bossFightButton;
  }
}
