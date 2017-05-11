import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class IntroPanel extends JPanel{
  CustomMouseListener mouseListener;
  JButton cont;
  Image introImage;
  IntroPanel( CustomMouseListener mouselistener){
    setLayout(null);
    mouseListener = mouselistener;
    cont = new JButton("Continue");
    cont.addMouseListener( mouseListener);
    cont.setBounds( 600, 475, 100, 50);

    add(cont);

    URL mapURL = getClass().getClassLoader().getResource("intro.jpg");
		ImageIcon mapIcon = new ImageIcon(mapURL);
		introImage = mapIcon.getImage();
  }
  //@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.drawImage(introImage, 0,0,800,475,null);

	}
  public JButton getContButton(){
    return cont;
  }

}
