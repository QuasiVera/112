package Game.Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Magian extends Hero { // герои с магическими способностями
    protected int mana;
    protected int maxMana;
    protected int accuracy;

    protected Magian(int x, int y, int init, ArrayList<Hero> team, String name, int health, int[] damage, int armor, int mana, int accuracy) {
        super(x, y, init, team, name, health, damage, armor);
        this.mana = mana;
        this.maxMana = mana;
        this.accuracy = accuracy;
    }
    protected void heal(Hero target){
        target.healed(new Random().nextInt(this.damage[0],this.damage[1]));
    }

    @Override
    public void step(ArrayList<Hero> enemy, ArrayList<Hero> friend) {
        int Hp = new Random().nextInt(this.damage[0],this.damage[1]*accuracy);
        if (this.health<1) return;
        if(this.mana<1 || this.mana<Hp){
            System.out.println("Не достаточно маны");
            return;
        }
        int max_damaged =0;
        float min = friend.get(0).health / friend.get(0).maxHealth;
        for (int i = 0; i < friend.size(); i++) {
                    if (friend.get(i).health<maxHealth){

                    if (friend.get(i).health / friend.get(i).maxHealth<min && friend.get(i).health!=0) {
                        min = friend.get(i).health / friend.get(i).maxHealth;
                        max_damaged = i;
                    }
                    }
        }
        if (min<1){
        friend.get(max_damaged).healed(Hp);
        this.mana -=Hp;}

    }

    @Override
    public String getInfo() {
        return String.format("%s  ma: %d",
                super.getInfo(), this.mana);
    }
}
