import javax.swing.*;

/**
 * Created by erdog on 7.05.2017.
 */
import javax.swing.JComboBox;

public class SkillMap extends JPanel{
    JButton back;
    JButton set;
    JComboBox<Skill> skillList1;
    JComboBox<Skill> skillList2;
    JComboBox<Skill> skillList3;
    JLabel first,second, third;
    private JButton cont;

    CustomMouseListener mouseListener;

    SkillMap( CustomMouseListener mouselistener){
        setLayout(null);
        mouseListener = mouselistener;

        first = new JLabel("Skill 1");
        second = new JLabel("Skill 2");
        third = new JLabel("Skill 3");

        back = new JButton("Back");
        set = new JButton( "Set All");
        cont = new JButton("Continue");

        back.addMouseListener( mouseListener);
        set.addMouseListener( mouseListener);
        cont.addMouseListener( mouseListener);

        first.setBounds( 75, 20, 300, 50);
        second.setBounds( 75, 105, 300, 50);
        third.setBounds( 75, 185, 300, 50);
        back.setBounds( 75, 360, 100, 50);
        set.setBounds( 75, 290 , 100, 50);
        cont.setBounds( 200, 360, 100, 50);

        skillList1 = new JComboBox<Skill>();
        skillList1.setBounds( 75, 65, 400, 50);

        skillList2 = new JComboBox<Skill>();
        skillList2.setBounds( 75, 145, 400, 50);

        skillList3 = new JComboBox<Skill>();
        skillList3.setBounds( 75, 225, 400, 50);

        add(first);
        add( second);
        add(third);
        add( skillList1);
        add(skillList2);
        add( skillList3);
        add(back);
        add( set);
        add(cont);
    }
    public JButton getSetButton(){
        return set;
    }
    public JButton getBackButton(){
        return back;
    }
    public JButton getContinueButton(){
      return cont;
    }
    public Skill getSkill1(){
        return (Skill) skillList1.getSelectedItem();
    }
    public Skill getSkill2(){
        return (Skill) skillList2.getSelectedItem();
    }
    public Skill getSkill3(){
        return (Skill) skillList3.getSelectedItem();
    }
    //public void addBoxerItem( Item item){
     //   boxerItems.addItem( item);
    //}
    public void setSkillList( Skill[] skilllist){
        for( int i = 0; i< skilllist.length; i++){
            skillList1.addItem(skilllist[i]);
            skillList2.addItem(skilllist[i]);
            skillList3.addItem(skilllist[i]);
        }
    }
}
