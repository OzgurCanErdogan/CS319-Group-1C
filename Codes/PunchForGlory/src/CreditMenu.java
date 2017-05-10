import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * Created by Taner on 09.05.2017.
 */
public class CreditMenu extends JPanel {

    JButton back;
    JTextArea credit_txtArea;

    CustomMouseListener2 mouseListener;

    public CreditMenu( CustomMouseListener2 mouselistener){
        mouseListener = mouselistener;
        setLayout(null);

        credit_txtArea = new JTextArea("Taner Baygun \nBeti Şahinkaya \nÖzgür Erdoğan \nÖmer Berk Uçar \nCs 319 - Bora Güngören");
        credit_txtArea.setBounds(250,50,300,250);
        credit_txtArea.setFont(new Font("Arial", Font.ITALIC, 24));
        credit_txtArea.setBackground(new Color(240,240,240));
        add(credit_txtArea);
        //credit_txtField = new JTextField(3);
        //credit_txtField.addActionListener(this);
        //credit_txtField.setBounds(150,275,100,25);
        //add(credit_txtField);


        back = new JButton("Back");
        back.setBounds(580,425,100,35);
        back.addMouseListener( mouseListener);
        add(back);

    }
    public JButton getBackButton(){
      return back;
    }
}
