package Units;

import java.util.ArrayList;

public abstract class Shooter extends Hero { // стрелки
    protected int arrows;
    protected int maxArrows;
    protected int accuracy;

    public Shooter(int init, ArrayList<Hero> team, String name, int health, int[] damage, int armor, int arrows, int maxArrows, int accuracy) {
        super(init,team, name, health, damage, armor);
        this.arrows = arrows;
        this.maxArrows = maxArrows;
        this.accuracy = accuracy;
    }
}
