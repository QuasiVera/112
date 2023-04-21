package Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Magian extends Hero { // герои с магическими способностями
    protected int mana;
    protected int maxMana;
    protected int accuracy;

    protected Magian(int init, ArrayList<Hero> team, String name, int health, int[] damage, int armor, int mana, int accuracy) {
        super(init, team, name, health, damage, armor);
        this.mana = mana;
        this.maxMana = mana;
        this.accuracy = accuracy;
    }
    protected void heal(Hero target){
        target.healed(new Random().nextInt(this.damage[0],this.damage[1]));
    }

    @Override
    public void step() {
        int Hp = new Random().nextInt(this.damage[0],this.damage[1]+1);
        if(mana<1 || mana<Hp){
            System.out.println("Не достаточно маны");
            return;
        }
        int max_damaged =0;
        float min = team.get(0).health / team.get(0).maxHealth;
        for (int i = 0; i < team.size(); i++) {
                    if (team.get(i).health / team.get(i).maxHealth<min && team.get(i).health!=0) {
                        min = team.get(i).health / team.get(i).maxHealth;
                        max_damaged = i;
                    }
        }

        team.get(max_damaged).healed(Hp);
        this.mana -=Hp;

    }
}
