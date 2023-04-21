package Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Hero implements GameInterface, Comparable{

    protected int initiative;
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int[] damage;
    protected int armor; // броня
    protected static Random rnd;

    protected ArrayList<Hero> team;


    static {
        Hero.rnd = new Random();
    }



    protected Hero(int initiative, ArrayList<Hero> team, String name, int health, int[] damage, int armor) {
        this.initiative = initiative;
        this.team = team;
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        if (new Random().nextBoolean()) this.health-=9;
        this.damage = damage;
        this.armor = armor;
    }

    public String getInfo() {
       return String.format("Name: %s  Health: %d  Type: %s Damage: %s Armor %d Init %d" ,
                this.name, this.health, this.getClass().getSimpleName(),
               Arrays.toString(this.damage), this.armor, this.initiative);

    }

    protected void healed(int Hp) {
        this.health = Hp + this.health > this.maxHealth ? this.maxHealth : Hp + this.health;
    }

    protected void getDamage(int doneDamage) {
            doneDamage = (int) (doneDamage * ((100 - this.armor) / 100));
            if ((this.health - doneDamage) > 0) {
                this.health -= doneDamage;
            } // тут будет метод умирания, если полученный урон > текущего здоровья
    }

    public void attack(Hero target) {
        target.getDamage(new Random().nextInt(this.damage[0], this.damage[1]+1));     // предположим пока, что в int[] damage только 2 числа
    }

    @Override
    public void step() {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int compareTo(Object o) {
        Hero hero = (Hero)o;
        return hero.initiative-this.initiative;
    }
}
