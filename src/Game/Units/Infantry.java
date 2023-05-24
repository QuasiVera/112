package Game.Units;


import Game.Main;
import java.util.ArrayList;
import java.util.Random;

public abstract class Infantry extends Hero{ // пехота
    protected int tool; // оружие, возможна, потом, замена типа данных; пока число


    public Infantry(int x, int y, int init, ArrayList<Hero> team, String name, int health, int[] damage, int armor, int tool) {
        super(x, y, init, team, name, health, damage, armor);
        this.tool = tool;
    }

    @Override
    public String getInfo() {

        return super.getInfo();
    }
    public void attack(Hero target) {
        if (target !=null)
        target.getDamage(new Random().nextInt(this.damage[0], this.damage[1]+1));}


    public boolean IsCellFree(Coordinates coord, ArrayList<Hero>team){
        for (Hero hero : team) {
            if(hero.coordinates.equals(coord) && hero.state!=State.die)
                return false;
        }
        return true;
    }

    protected void move(ArrayList<Hero> enemy, Hero closestEnemy) {
        int x = this.coordinates.deltaCoord(closestEnemy.coordinates)[0];
        int y = this.coordinates.deltaCoord(closestEnemy.coordinates)[1];
        int dx = this.coordinates.x;
        int dy = this.coordinates.y;

        if (Math.abs(x) > Math.abs(y)) {
            if (x < 0 && dx<=10) dx++;
            if (x>0 && dx>0) dx--;
            if (IsCellFree(new Coordinates(dx, dy),Main.allTeam)) {
                this.coordinates.x = dx;

            } else {
                double dist1 = new Coordinates(dx,dy++).distanceSearch(closestEnemy.coordinates);
                double dist2 = new Coordinates(dx,dy--).distanceSearch(closestEnemy.coordinates);
                if (dist1<dist2) this.coordinates.y = dy; else this.coordinates.y = dy;
            }

        } else {
            if (y < 0 && dy<=10) dy++;
            if (y > 0 && dy>0 ) dy--;
            if (IsCellFree(new Coordinates(dx, dy),Main.allTeam)) {
                this.coordinates.y = dy;

            } else {
                double dist1 = new Coordinates(dx++,dy).distanceSearch(closestEnemy.coordinates);
                double dist2 = new Coordinates(dx--,dy).distanceSearch(closestEnemy.coordinates);
                if (dist1<dist2) this.coordinates.x = dx; else this.coordinates.x = dx;
            }

        }

    }
//------------Альтернативный метод движения, не подошел, оставила для себя
    protected int [] move1 (Hero enemy){
        int [] cellToChoose = new int[2];
        double minDisctance = this.coordinates.distanceSearch(enemy.coordinates);
        ArrayList<int []> newCoords = new ArrayList<>();
        int dx = this.coordinates.x;
        int dy = this.coordinates.y;
        if (dx + 1 < 10 && IsCellFree(new Coordinates(dx + 1, dy), Main.allTeam)) newCoords.add(new int[]{dx + 1, dy});
        if (dx - 1 > -1 && IsCellFree(new Coordinates(dx - 1, dy), Main.allTeam)) newCoords.add(new int[]{dx - 1, dy});
        if (dy + 1 < 10 && IsCellFree(new Coordinates(dx, dy+1), Main.allTeam)) newCoords.add(new int[]{dx, dy + 1});
        if (dy - 1 > -1 && IsCellFree(new Coordinates(dx, dy-1), Main.allTeam)) newCoords.add(new int[]{dx, dy - 1});

        for (int [] cell: newCoords){
            Coordinates temp = new Coordinates(cell[0],cell[1]);
            if (temp.distanceSearch(enemy.coordinates)<minDisctance){
                minDisctance = temp.distanceSearch(enemy.coordinates);
                cellToChoose[0] = cell[0];
                cellToChoose[1] = cell[1];

            }
        } return cellToChoose;
    }

    protected Hero findClosedEnemy (ArrayList<Hero> enemy){
        double min =Integer.MAX_VALUE;
        int index_closedEnemy =0;
        Hero closedEnemy = enemy.get(0);
        for (int i = 0; i < enemy.size(); i++) {
            double temp = this.coordinates.distanceSearch(enemy.get(i).coordinates);
            if (temp<min){
                //index_closedEnemy =i;
                closedEnemy = enemy.get(i);
                min = temp;
            }
        }return closedEnemy;
    }

    @Override
    public void step(ArrayList<Hero> enemy, ArrayList<Hero> friend) {
        if (this.health < 1 ) return;
        Hero closedEnemy = findClosedEnemy(enemy);
        //int [] move = this.move1(closedEnemy);
        //this.coordinates.x = move[0];
        //this.coordinates.y = move[1];
        this.move(enemy, closedEnemy);

        if (this.coordinates.distanceSearch(closedEnemy.coordinates)<2 && closedEnemy.health>0){
            this.attack(closedEnemy);
            return;}

        }

    }


