import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

/**
 * Created by erdog on 7.05.2017.
 */
public class SkillMap extends JPanel {

    JButton back;
    Image gymImage;
    CustomMouseListener mouseListener;
    SkillMap(CustomMouseListener mouselistener){

        setLayout(null);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        URL mapURL = getClass().getClassLoader().getResource("gym.jpeg");
        ImageIcon mapIcon = new ImageIcon(mapURL);
        gymImage = mapIcon.getImage();
        mouseListener = mouselistener;

        back = new JButton("Back");
        back.setBounds(100,400,150,50);

        back.addMouseListener(mouseListener);


        add(back);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setOpaque(false);
        setBackground(Color.WHITE);
        g.drawImage(gymImage, 0,0,800,600,null);
    }
    public JButton getBackButton(){
        return back;
    }
}
