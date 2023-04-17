package Units;

public class Magian extends Hero{ // герои с магическими способностями
    protected int mana;
    protected int maxMana;
    protected int accuracy;

    public Magian(String name, int health, int[] damage, int armor, int mana, int accuracy) {
        super(name, health, damage, armor);
        this.mana = mana;
        this.maxMana = mana;
        this.accuracy = accuracy;
    }

}
