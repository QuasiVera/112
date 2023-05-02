package Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Hero implements GameInterface, Comparable<Hero>{
    public int[] getCoords() {
        int[] coord = new int[] {coordinates.x, coordinates.y};
        return coord;
    }

    public int getHp() {
        return health;
    }

    enum State {
        ready, busy, die
    }

    protected int initiative;
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int[] damage;
    protected int armor; // броня

    protected ArrayList<Hero> team;
    protected Coordinates coordinates;
    protected State state;





    protected Hero(int x, int y, int initiative, ArrayList<Hero> team, String name, int health, int[] damage, int armor) {
        this.coordinates = new Coordinates(x,y);
        this.initiative = initiative;
        this.team = team;
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        //if (new Random().nextBoolean()) this.health-=9; //задать изначальное повреждение герою
        this.damage = damage;
        this.armor = armor;
        this.state = State.ready;
    }

    public String getInfo() {
       return String.format("N: %s  %s Hp: %d Dam: %s Ar %d In %d" ,
                this.name, this.getClass().getSimpleName(), this.health,
               Arrays.toString(this.damage), this.armor, this.initiative);

    }

    protected void healed(int Hp) {
        this.health = Hp + this.health > this.maxHealth ? this.maxHealth : Hp + this.health;
    }

    protected void getDamage(int doneDamage) {
            //doneDamage = (int) (doneDamage * ((100 - this.armor) / 100)); плохо работает на маленьких числах
            doneDamage =  doneDamage-armor;
            this.health -= doneDamage;
            if (health<0){
                health=0;
                this.state = State.die;
            }

    }

    public void attack(Hero target) {

    }

    @Override
    public void step(ArrayList<Hero> enemy, ArrayList<Hero> friend) {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int compareTo(Hero o) {
        return o.initiative-this.initiative;
    }
}
