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

        if(mana<1){
            System.out.println("Нет маны");
            return;
        }
        int index_damaged =0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i+1; j <team.size()-1 ; j++) {
                if(team.get(i).health!=0 || team.get(j).health!=0) {
                    if (team.get(i).health / team.get(i).maxHealth < team.get(j).health / team.get(j).maxHealth) {
                        index_damaged = i;
                    }
                }
            }
        }
        team.get(index_damaged).healed(new Random().nextInt(this.damage[0],this.damage[1]));
        this.mana -=1;

    }
}
