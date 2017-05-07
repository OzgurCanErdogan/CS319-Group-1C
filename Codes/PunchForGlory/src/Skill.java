/**
 * Created by erdog on 6.05.2017.
 */
public class Skill {
    private int str, agi, vit, missRate, exp, baseDamage, totalDamage;
    private double factor;
    private  String name;
    Skill(String name){
        this.name = name;
    }
    Skill(String name, int str, int agi, int vit, double factor, int baseDamage, int missRate, int exp){
        this.name = name;
        this.str = str;
        this.agi = agi;
        this.vit = vit;
        this.factor = factor;
        this.baseDamage = baseDamage;
        this.missRate = missRate;
        this.exp = exp;
        totalDamage = (int) ((str/2*factor)+ agi/3*factor)+baseDamage;

    }



    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public void setMissRate(int missRate) {
        this.missRate = missRate;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public int getAgi() {
        return agi;
    }

    public int getStr() {
        return str;
    }

    public int getVit() {
        return vit;
    }

    public String getName() {
        return name;
    }

    public double getFactor() {
        return factor;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getExp() {
        return exp;
    }

    public int getMissRate() {
        return missRate;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public void updateDamage(){
        totalDamage = (int) ((str/2*factor)+ agi/3*factor)+baseDamage;
    }
}
