package Units;

import java.util.ArrayList;

public abstract class Infantry extends Hero{ // пехота
    protected int tool; // оружие, возможна, потом, замена типа данных; пока число


    public Infantry(int init, ArrayList<Hero> team, String name, int health, int[] damage, int armor, int tool) {
        super(init, team, name, health, damage, armor);
        this.tool = tool;
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
