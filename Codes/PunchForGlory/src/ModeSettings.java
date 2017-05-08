import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class ModeSettings extends JPanel {
    public static final int height = 600;
    public static final int width = 800;
    JLabel mousePoint;
    JFrame window;

    JRadioButton godMode;
    JRadioButton normalMode;
    JButton back;
    CustomMouseListener2 mouse;
    ButtonGroup buttonGroup;
    private int mode;

    public ModeSettings( CustomMouseListener2 mouseListener){
        mouse = mouseListener;

        //setLayout(null);
        godMode = new JRadioButton("God Mode");
        godMode.setMnemonic(KeyEvent.VK_C);
        godMode.setSelected(false);

        normalMode = new JRadioButton("Normal Mode");
        normalMode.setMnemonic(KeyEvent.VK_C);
        normalMode.setSelected(true);

        back = new JButton("Back");
        setBounds(500,200,150,50);

        buttonGroup = new ButtonGroup();

        buttonGroup.add(normalMode);
        buttonGroup.add(godMode);
        back.addMouseListener( mouse);

        //JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        //checkPanel.add(godMode);
        //checkPanel.add(normalMode);
        add(godMode);
        add(normalMode);
        add(back);

        //add(checkPanel, BorderLayout.LINE_START);
        //add(pictureLabel, BorderLayout.CENTER);
        //setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

    }
    public JButton getBackButton(){
      return back;
    }
    public int getMode(){
      if( normalMode.isSelected())
        return 0;
      else
        return 1;
    }

}
