import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Taner on 09.05.2017.
 */
public class HelpMenu extends JPanel {
    CustomMouseListener2 mouseListener;

    JButton back;
    JTextArea credit_txtArea;


    public HelpMenu( CustomMouseListener2 mouselistener){
        mouseListener = mouselistener;
        setLayout(null);

        credit_txtArea = new JTextArea("Welcome to Punch For Glory \nIt is basically a box game \nThe purpose is to beat boss" +
                "\nTo win matches you should make enemy's health 0 \nBefore he does yours \nTo meet the boss win 2 matches in Arena");
        credit_txtArea.setBounds(50,50,500,250);
        credit_txtArea.setFont(new Font("Arial", 0, 20));

        credit_txtArea.setBackground(new Color(240,240,240));
        add(credit_txtArea);


        back = new JButton("Back");
        back.setBounds(580,425,100,35);
        back.addMouseListener( mouseListener);
        add(back);

    }
    public JButton getBackButton(){
      return back;
    }

}
