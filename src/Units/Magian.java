package Units;

import java.util.Random;

public abstract class Magian extends Hero{ // герои с магическими способностями
    protected int mana;
    protected int maxMana;
    protected int accuracy;

    protected Magian(String name, int health, int[] damage, int armor, int mana, int accuracy) {
        super(name, health, damage, armor);
        this.mana = mana;
        this.maxMana = mana;
        this.accuracy = accuracy;
    }
    protected void heal(Hero target){
        target.healed(new Random().nextInt(this.damage[0],this.damage[1]));
    }

}
