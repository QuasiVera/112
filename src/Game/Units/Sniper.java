package Game.Units;

import java.util.ArrayList;

public class Sniper extends Shooter {
    public Sniper(ArrayList<Hero> team, String name, int x, int y) {

        super(x, y, 6,team, name, 10, new int [] {1,2}, 2, 13,1);

    }



}
