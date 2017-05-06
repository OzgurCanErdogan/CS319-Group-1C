import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class ModeSettings extends JPanel implements ItemListener {
    public static final int height = 600;
    public static final int width = 800;
    JLabel mousePoint;
    JFrame window;
    CardLayout cardLayout;

    JCheckBox godMode;
    JCheckBox normalMode;
    JButton back;
    CustomMouseListener mouse;
    JPanel mainPanel;

    public ModeSettings( JPanel panel, CardLayout cl){
        mainPanel = panel;
        cardLayout = cl;
        //setLayout(null);
        godMode = new JCheckBox("God Mode");
        godMode.setMnemonic(KeyEvent.VK_C);
        godMode.setSelected(true);

        normalMode = new JCheckBox("Normal Mode");
        normalMode.setMnemonic(KeyEvent.VK_C);
        normalMode.setSelected(true);

        back = new JButton("Back");
        setBounds(500,200,150,50);

        godMode.addItemListener(this);
        normalMode.addItemListener(this);
        back.addMouseListener( new CustomMouseListener());

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

    @Override
    public void itemStateChanged(ItemEvent e) {
        int index = 0;
        char c = '-';
        Object source = e.getItemSelectable();

        if (source == godMode) {
            index = 0;
            c = 'c';
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
